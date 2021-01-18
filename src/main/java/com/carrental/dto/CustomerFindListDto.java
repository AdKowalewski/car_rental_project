package com.carrental.dto;

import com.carrental.enums.IdDocumentEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFindListDto {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDto address;

    private IdDocumentEnum idDocumentEnum;

    private String documentNum;
}
