package com.carrental.security;

import com.carrental.model.Customer;
import com.carrental.service.CustomerService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final CustomerService customerService;

    public JwtUserDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer;
        SimpleGrantedAuthority simpleGrantedAuthority;
        customer = customerService.findByLogin(login);
        simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + customer.getUserType().name());

        return new User(customer.getLogin(), customer.getPassword(), Collections.singletonList(simpleGrantedAuthority));

    }
}
