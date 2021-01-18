package com.carrental.mapper;

import com.carrental.dto.AuthDto;
import com.carrental.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerAuthMapper {

    CustomerAuthMapper INSTANCE = Mappers.getMapper(CustomerAuthMapper.class);

    Customer toEntity(AuthDto customerDto);

    AuthDto toDto(Customer customer);
}
