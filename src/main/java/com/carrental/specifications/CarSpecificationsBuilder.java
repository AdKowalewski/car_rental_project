package com.carrental.specifications;

import com.carrental.model.Car;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public CarSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public CarSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Car> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Car>> specs = params.stream()
                .map(CarSpecification::new)
                .collect(Collectors.toList());

        Specification<Car> result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                    .isOrPredicate()
                    ? Specification.where(result)
                    .or(specs.get(i))
                    : Specification.where(result)
                    .and(specs.get(i));
        }
        return result;
    }
}
