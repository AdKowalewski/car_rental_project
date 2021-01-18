package com.carrental.dto;

import com.carrental.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationFindListDto {

    private Long id;

    private CustomerFindListDto customer;

    private CarFindListDto car;

    private ReservationStatus reservationStatus;

    private WorkerFindListDto rentWorker;

    private WorkerFindListDto receiveWorker;

    private String rentDescription;

    private String receiveDescription;

    private LocalDateTime rentDate;

    private LocalDateTime returnDate;

    private DepartmentFindListDto departmentFrom;

    private DepartmentFindListDto departmentTo;

    private BigDecimal totalCost;
}
