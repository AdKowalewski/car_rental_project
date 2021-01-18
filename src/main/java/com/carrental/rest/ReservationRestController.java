package com.carrental.rest;

import com.carrental.dto.CustomerFindListDto;
import com.carrental.dto.ReservationCreateDto;
import com.carrental.dto.ReservationDto;
import com.carrental.dto.ReservationFindListDto;
import com.carrental.enums.ReservationStatus;
import com.carrental.mapper.CustomerFindListMapper;
import com.carrental.mapper.ReservationCreateMapper;
import com.carrental.mapper.ReservationFindListMapper;
import com.carrental.mapper.ReservationMapper;
import com.carrental.model.Reservation;
import com.carrental.service.ReservationService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationCreateDto addReservation(@RequestBody ReservationCreateDto dto) {
        Reservation reservation = ReservationCreateMapper.INSTANCE.toEntity(dto);
        reservation.setReservationStatus(ReservationStatus.CREATED);
        reservation.setTotalCost(reservationService.countCost(dto.getCar().getDailyFee(), dto.getRentDate(), dto.getReturnDate()));
        try {
            reservation = reservationService.save(reservation);
        } catch (ConstraintViolationException e) {
            return null;
        }
        return ReservationCreateMapper.INSTANCE.toDto(reservation);
    }

    @PutMapping("/{reservationId}")
    public Reservation updateReservation(
            @PathVariable("reservationId") Long id,
            @RequestBody ReservationFindListDto dto) {
        ReservationFindListDto oldReservationDto = ReservationFindListMapper.INSTANCE.toDto(reservationService.find(id));
        oldReservationDto.setCustomer(dto.getCustomer());
        oldReservationDto.setCar(dto.getCar());
        oldReservationDto.setReservationStatus(dto.getReservationStatus());
        oldReservationDto.setRentWorker(dto.getRentWorker());
        oldReservationDto.setReceiveWorker(dto.getReceiveWorker());
        oldReservationDto.setRentDescription(dto.getRentDescription());
        oldReservationDto.setReceiveDescription(dto.getReceiveDescription());
        oldReservationDto.setRentDate(dto.getRentDate());
        oldReservationDto.setReturnDate(dto.getReturnDate());
        oldReservationDto.setDepartmentFrom(dto.getDepartmentFrom());
        oldReservationDto.setDepartmentTo(dto.getDepartmentTo());
        oldReservationDto.setTotalCost(dto.getTotalCost());

        return reservationService.save(ReservationFindListMapper.INSTANCE.toEntity(oldReservationDto));
    }

    @GetMapping(path = "{reservationId}")
    public @ResponseBody
    ReservationDto getReservationById(@PathVariable("reservationId") Long id) {
        return ReservationMapper.INSTANCE.toDto(reservationService.find(id));
    }

    @GetMapping
    public List<ReservationFindListDto> getAllReservations() {
        return reservationService.findAll().stream()
                .map(ReservationFindListMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{reservationId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReservationById(@PathVariable("reservationId") Long id) {
        reservationService.delete(id);
    }
}
