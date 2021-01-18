package com.carrental.mapper;

import com.carrental.dto.ReservationFindListDto;
import com.carrental.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationFindListMapper {

    ReservationFindListMapper INSTANCE = Mappers.getMapper(ReservationFindListMapper.class);

    Reservation toEntity(ReservationFindListDto reservationDto);

    ReservationFindListDto toDto(Reservation reservation);
}
