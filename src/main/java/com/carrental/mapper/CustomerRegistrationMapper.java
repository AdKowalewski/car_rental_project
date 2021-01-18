package com.carrental.mapper;

import com.carrental.dto.CustomerRegistrationDto;
import com.carrental.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerRegistrationMapper {

    CustomerRegistrationMapper INSTANCE = Mappers.getMapper(CustomerRegistrationMapper.class);

    Customer toEntity(CustomerRegistrationDto customerDto);

    CustomerRegistrationDto toDto(Customer customer);
}
