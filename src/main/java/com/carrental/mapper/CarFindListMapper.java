package com.carrental.mapper;

import com.carrental.dto.CarFindListDto;
import com.carrental.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarFindListMapper {

    CarFindListMapper INSTANCE = Mappers.getMapper(CarFindListMapper.class);

    Car toEntity(CarFindListDto carDto);

    CarFindListDto toDto(Car car);
}
