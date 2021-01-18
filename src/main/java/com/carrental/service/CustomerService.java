package com.carrental.service;

import com.carrental.exceptions.NotFoundException;
import com.carrental.model.Customer;
import com.carrental.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer find(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(getCustomerNotFoundExceptionSupplier(id));
    }

    public Customer findByIdWithReservations(Long id) {
        return customerRepository.findByIdWithReservations(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    private Supplier<RuntimeException> getCustomerNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Customer not found: %s", id));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Customer findByLogin (String login) {
        return customerRepository.findByLogin(login).orElseThrow(() -> new NotFoundException(String.format("Customer wit login: %s not found", login)));
    }
}
