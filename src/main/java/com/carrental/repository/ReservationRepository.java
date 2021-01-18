package com.carrental.repository;

import com.carrental.enums.ReservationStatus;
import com.carrental.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    List<Reservation> findAllByCarRegistrationNumber (String reg);
//
//    List<Reservation> findAllByCarId (Long id);
//
//    List<Reservation> findAllByReservationStatus (ReservationStatus reservationStatus);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.rent_date) = :monthNum AND day(r.rent_date) = :dayNum AND year(r.rent_date) = :year",nativeQuery = true)
//    List<Reservation> findAllByRentDateGivenMonthAndDayAndYear (@Param("monthNum")Integer monthNum, @Param("dayNum")Integer dayNum, @Param("year")Integer year);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.rent_date) = :monthNum AND year(r.rent_date) = :year",nativeQuery = true)
//    List<Reservation> findAllByRentDateGivenMonthAndYear (@Param("monthNum")Integer monthNum, @Param("year")Integer year);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.return_date) = :monthNum AND day(r.return_date) = :dayNum AND year(r.return_date) = :year",nativeQuery = true)
//    List<Reservation> findAllByReturnDateGivenMonthAndDayAndYear (@Param("monthNum")Integer monthNum, @Param("dayNum")Integer dayNum, @Param("year")Integer year);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.return_date) = :monthNum AND year(r.return_date) = :year",nativeQuery = true)
//    List<Reservation> findAllByReturnDateGivenMonthAndYear (@Param("monthNum")Integer monthNum, @Param("year")Integer year);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.rent_date) = :monthNum AND day(r.rent_date) = :dayNum AND year(r.rent_date) = :year AND r.from_department_id = :deptId",nativeQuery = true)
//    List<Reservation> findAllByRentDateGivenMonthAndDayAndYearAndDepartmentFromId (@Param("monthNum")Integer monthNum, @Param("dayNum")Integer dayNum, @Param("year")Integer year, @Param("deptId")Long deptId);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.rent_date) = :monthNum AND year(r.rent_date) = :year AND r.from_department_id = :deptId",nativeQuery = true)
//    List<Reservation> findAllByRentDateGivenMonthAndYearAndDepartmentFromId (@Param("monthNum")Integer monthNum, @Param("year")Integer year, @Param("deptId")Long deptId);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.return_date) = :monthNum AND day(r.return_date) = :dayNum AND year(r.return_date) = :year AND r.to_department_id = :deptId",nativeQuery = true)
//    List<Reservation> findAllByReturnDateGivenMonthAndDayAndYearAndDepartmentFromId (@Param("monthNum")Integer monthNum, @Param("dayNum")Integer dayNum, @Param("year")Integer year, @Param("deptId")Long deptId);
//
//    @Query(value ="SELECT * FROM reservation r WHERE month(r.return_date) = :monthNum AND year(r.return_date) = :year AND r.to_department_id = :deptId",nativeQuery = true)
//    List<Reservation> findAllByReturnDateGivenMonthAndYearAndDepartmentFromId (@Param("monthNum")Integer monthNum, @Param("year")Integer year, @Param("deptId")Long deptId);
//
//    @Query("select r from reservation r where r.car.id = :id AND NOT r.reservationStatus = 'ENDED'")
//    List<Reservation> findAllReservationsForGivenCarIdAndStatusNotEnded (@Param("id") Integer id);
}
