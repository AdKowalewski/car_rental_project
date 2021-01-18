package com.carrental.dto;

import com.carrental.enums.BodyType;
import com.carrental.enums.CarStatus;
import com.carrental.enums.FuelType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarFindListDto {

    private Long id;

    private String brand;

    private String model;

    private String registrationNumber;

    private BodyType bodyType;

    private Double engineCapacity;

    private Integer horsePower;

    private Integer numberOfSeats;

    private Integer numberOfDoors;

    private FuelType fuelType;

    private List<PhotoDto> photos;

    private boolean isManual;

    private boolean hasAc;

    private Integer year;

    private Integer mileage;

    private String color;

    private CarStatus status;

    private String description;

    private Integer dailyFee;
}
