package com.carrental.mapper;

import com.carrental.dto.PhotoDto;
import com.carrental.model.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhotoMapper {

    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    Photo toEntity(PhotoDto photoDto);

    PhotoDto toDto(Photo photo);

}
