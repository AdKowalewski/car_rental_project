package com.carrental.mapper;

import com.carrental.dto.CustomerFindListDto;
import com.carrental.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerFindListMapper {

    CustomerFindListMapper INSTANCE = Mappers.getMapper(CustomerFindListMapper.class);

    Customer toEntity(CustomerFindListDto customerDto);

    CustomerFindListDto toDto(Customer customer);
}
