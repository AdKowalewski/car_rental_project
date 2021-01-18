package com.carrental.rest;

import com.carrental.dto.CustomerDto;
import com.carrental.dto.CustomerFindListDto;
import com.carrental.dto.CustomerRegistrationDto;
import com.carrental.enums.UserType;
import com.carrental.mapper.CustomerFindListMapper;
import com.carrental.mapper.CustomerMapper;
import com.carrental.mapper.CustomerRegistrationMapper;
import com.carrental.model.Customer;
import com.carrental.service.CustomerService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public CustomerRegistrationDto addCustomer(@RequestBody CustomerRegistrationDto dto) {
        Customer customer = CustomerRegistrationMapper.INSTANCE.toEntity(dto);
        customer.setUserType(UserType.CUSTOMER);
        try {
            customer = customerService.save(customer);
        } catch (ConstraintViolationException e) {
        return null;
        }
        return CustomerRegistrationMapper.INSTANCE.toDto(customer);
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(
            @PathVariable("customerId") Long id,
            @RequestBody CustomerFindListDto dto) {
        //Customer oldCustomer = customerService.find(id);
        CustomerFindListDto oldCustomerDto = CustomerFindListMapper.INSTANCE.toDto(customerService.find(id));
        oldCustomerDto.setLogin(dto.getLogin());
        oldCustomerDto.setFirstName(dto.getFirstName());
        oldCustomerDto.setLastName(dto.getLastName());
        oldCustomerDto.setEmail(dto.getEmail());
        oldCustomerDto.setAddress(dto.getAddress());
        oldCustomerDto.setIdDocumentEnum(dto.getIdDocumentEnum());
        oldCustomerDto.setDocumentNum(dto.getDocumentNum());

        return customerService.save(CustomerFindListMapper.INSTANCE.toEntity(oldCustomerDto));
    }

    @GetMapping(path = "/customers/{customerId}")
    public @ResponseBody
    CustomerDto getCustomerById(@PathVariable("customerId") Long id) {
        return CustomerMapper.INSTANCE.toDto(customerService.findByIdWithReservations(id));
    }

    @GetMapping("/customers")
    public List<CustomerFindListDto> getAllCustomersOrByFirstNameAndLastName(
            @RequestParam(value = "firstName", required = false) Optional<String> firstName,
            @RequestParam(value = "lastName", required = false) Optional<String> lastName) {
        if(firstName.isPresent() && lastName.isPresent()){
            return customerService.findByFirstNameAndLastName(firstName.get(), lastName.get()).stream()
                    .map(CustomerFindListMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
        } else {
            return customerService.findAll().stream()
                    .map(CustomerFindListMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
        }
    }

    @DeleteMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomerById(@PathVariable("customerId") Long id) {
        customerService.delete(id);
    }
}
