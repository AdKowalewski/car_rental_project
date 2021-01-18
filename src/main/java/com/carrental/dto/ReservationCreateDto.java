package com.carrental.dto;

import com.carrental.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationCreateDto {

    private Long id;

    private CustomerFindListDto customer;

    private CarDto car;

    private ReservationStatus reservationStatus;

    private LocalDateTime rentDate;

    private LocalDateTime returnDate;

    private DepartmentDto departmentFrom;

    private DepartmentDto departmentTo;

    private BigDecimal totalCost;
}
