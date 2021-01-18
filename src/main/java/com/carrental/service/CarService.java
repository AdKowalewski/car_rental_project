package com.carrental.service;

import com.carrental.exceptions.NotFoundException;
import com.carrental.model.Car;
import com.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car find(Long id) {
        return carRepository.findById(id)
                .orElseThrow(getCarNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getCarNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Car not found: %s", id));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }
}
