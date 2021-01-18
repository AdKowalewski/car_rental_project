package com.carrental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegistrationDto {

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
