package com.carrental.dto;

import com.carrental.enums.BodyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarFilterDto {

    private String brand;

    private BodyType bodyType;

    private Boolean isManual;

    private Integer minPrice;

    private Integer maxPrice;

    private String city;
}
