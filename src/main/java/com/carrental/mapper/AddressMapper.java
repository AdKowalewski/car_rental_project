package com.carrental.mapper;

import com.carrental.dto.AddressDto;
import com.carrental.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);

}
