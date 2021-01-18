package com.carrental.repository;

import com.carrental.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Department> findByAddress_City(String city);

    @Query("Select d from Department d left join fetch worker w where d.name =:name")
    Optional<Department> findByNameWithWorkers(@Param("name")String name);
}
