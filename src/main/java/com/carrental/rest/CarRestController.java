package com.carrental.rest;

import com.carrental.dto.CarDto;
import com.carrental.mapper.CarMapper;
import com.carrental.model.Car;
import com.carrental.repository.CarRepository;
import com.carrental.service.CarService;
import com.carrental.specifications.CarSpecificationsBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    private final CarService carService;
    private final CarRepository carRepository;

    public CarRestController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CarDto addCar(@RequestBody CarDto dto, @RequestParam(value = "deptId") Long deptId ) {
            Car car = CarMapper.INSTANCE.toEntity(dto);
            car.addDepartment(deptId);
           car = carService.save(car);
           return CarMapper.INSTANCE.toDto(car);
    }

    @GetMapping
    @ResponseBody
    public List<CarDto> getCars(@RequestParam(value = "search", required = false) String search, @RequestParam(value = "page", required = false) Integer page) {
        CarSpecificationsBuilder builder = new CarSpecificationsBuilder();

        Pattern pattern = Pattern.compile("(\\w+)(:|<|>)(\\w+),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Car> spec = builder.build();
        return carRepository.findAll(spec,PageRequest.of(page == null ? 0 : page,5)).stream().map(CarMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{carId}")
    public @ResponseBody
    CarDto getCarById(@PathVariable("carId") Long id) {
        return CarMapper.INSTANCE.toDto(carService.find(id));
    }

    @DeleteMapping("/{carId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCarById(@PathVariable("carId") Long id) {
        carService.delete(id);
    }
}
