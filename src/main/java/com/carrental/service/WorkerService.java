package com.carrental.service;

import com.carrental.enums.UserType;
import com.carrental.exceptions.NotFoundException;
import com.carrental.model.Worker;
import com.carrental.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker find(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(getWorkerNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getWorkerNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Worker not found: %s", id));
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    public void delete (Long id){
        workerRepository.deleteById(id);
    }

    public Worker findByLogin(String login) {
        return workerRepository.findByLogin(login).orElseThrow(() ->
                new NotFoundException("Worker not found"));
    }

    public List<Worker> findAllByFirstNameAndLastName(String firstName, String lastName){
        return workerRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Worker findByEmail(String email) {
        return workerRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException("Worker not found"));
    }

    public List<Worker> findAllByUserType(UserType userType){
        return workerRepository.findAllByUserType(userType);
    }

    public List<Worker> findAllByUserTypeAndDepartmentName(UserType userType, String departmentName){
        return workerRepository.findAllByUserTypeAndDepartmentName(userType, departmentName);
    }
}
