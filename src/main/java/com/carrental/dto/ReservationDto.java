package com.carrental.dto;

import com.carrental.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDto {

    private Long id;

    private CustomerFindListDto customer;

    private CarDto car;

    private ReservationStatus reservationStatus;

    private WorkerDto rentWorker;

    private WorkerDto receiveWorker;

    private String rentDescription;

    private String receiveDescription;

    private LocalDateTime rentDate;

    private LocalDateTime returnDate;

    private DepartmentDto departmentFrom;

    private DepartmentDto departmentTo;

    private BigDecimal totalCost;
}
