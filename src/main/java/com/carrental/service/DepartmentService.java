package com.carrental.service;

import com.carrental.exceptions.NotFoundException;
import com.carrental.model.Department;
import com.carrental.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department find(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(getDepartmentNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getDepartmentNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Department not found: %s", id));
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public List<Department> findByCity(final String city){
        return departmentRepository.findByAddress_City(city);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void delete (Long id){
        departmentRepository.deleteById(id);
    }
}
