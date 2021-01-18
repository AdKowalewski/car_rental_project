package com.carrental.mapper;

import com.carrental.dto.CarFilterDto;
import com.carrental.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarFilterMapper {

    CarFilterMapper INSTANCE = Mappers.getMapper(CarFilterMapper.class);

    Car toEntity(CarFilterDto carDto);

    CarFilterDto toDto(Car car);
}
