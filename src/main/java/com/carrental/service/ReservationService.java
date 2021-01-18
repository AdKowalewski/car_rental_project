package com.carrental.service;

import com.carrental.exceptions.NotFoundException;
import com.carrental.model.Reservation;
import com.carrental.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation find(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(getReservationNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getReservationNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Reservation not found: %s", id));
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void delete (Long id){
        reservationRepository.deleteById(id);
    }

    public BigDecimal countCost(Integer dailyCost, LocalDateTime time1, LocalDateTime time2) {

        Duration duration = Duration.between(time1, time2);
        return BigDecimal.valueOf(dailyCost * duration.toDays());
    }
}
