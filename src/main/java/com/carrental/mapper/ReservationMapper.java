package com.carrental.mapper;

import com.carrental.dto.ReservationDto;
import com.carrental.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation toEntity(ReservationDto reservationDto);

    ReservationDto toDto(Reservation reservation);

}
