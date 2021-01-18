package com.carrental.model;

import com.carrental.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity(name = "reservation")
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(name = "rent_worker_id", referencedColumnName = "id")
    private Worker rentWorker;

    @ManyToOne
    @JoinColumn(name = "receive_worker_id", referencedColumnName = "id")
    private Worker receiveWorker;

    @Column
    private String rentDescription;

    @Column
    private String receiveDescription;

    @Column(nullable = false)
    private LocalDateTime rentDate;

    @Column(nullable = false)
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "from_department_id", referencedColumnName = "id")
    private Department departmentFrom;

    @ManyToOne
    @JoinColumn(name = "to_department_id", referencedColumnName = "id")
    private Department departmentTo;

    @Column(nullable = false)
    private BigDecimal totalCost;
}
