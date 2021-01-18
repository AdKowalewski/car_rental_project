package com.carrental.dto;

import com.carrental.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkerDto {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDto address;

    private UserType userType;

    private DepartmentFindListDto department;

    private LocalDateTime hireDate;

}
