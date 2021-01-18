package com.carrental.mapper;

import com.carrental.dto.ReservationCreateDto;
import com.carrental.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationCreateMapper {

    ReservationCreateMapper INSTANCE = Mappers.getMapper(ReservationCreateMapper.class);

    Reservation toEntity(ReservationCreateDto reservationDto);

    ReservationCreateDto toDto(Reservation reservation);
}
