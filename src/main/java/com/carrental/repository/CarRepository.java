package com.carrental.repository;

import com.carrental.enums.CarStatus;
import com.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {

    Optional<Car> findByRegistrationNumber (String registrationNumber);

    @Query("Select c from Department d left join fetch car c where d.name =:name")
    List<Car> findAllByDepartmentName (@Param("name")String name);

    List<Car> findByStatus (CarStatus status);


}
