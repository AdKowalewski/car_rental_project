package com.carrental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentFindListDto {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private AddressDto address;
}
