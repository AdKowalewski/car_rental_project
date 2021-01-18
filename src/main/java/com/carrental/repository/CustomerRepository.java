package com.carrental.repository;

import com.carrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("Select c from Customer c left join fetch c.reservations where c.id =:id")
    Optional<Customer> findByIdWithReservations (@Param("id")Long id);

    List<Customer> findAllByFirstNameAndLastName (String firstName, String lastName);

    Optional<Customer> findByLogin (String login);
}
