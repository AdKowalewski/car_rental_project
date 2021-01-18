package com.carrental.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentDto {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private AddressDto address;

    private List<WorkerFindListDto> workers;

    private List<CarFindListDto> cars;
}
