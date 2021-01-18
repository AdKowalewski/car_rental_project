package com.carrental.repository;

import com.carrental.enums.UserType;
import com.carrental.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Optional<Worker> findByLogin (String login);

    List<Worker> findAllByFirstNameAndLastName (String firstName, String lastName);

    Optional<Worker> findByEmail (String email);

    List<Worker> findAllByUserType (UserType userType);

    List<Worker> findAllByUserTypeAndDepartmentName (UserType userType, String name);

}
