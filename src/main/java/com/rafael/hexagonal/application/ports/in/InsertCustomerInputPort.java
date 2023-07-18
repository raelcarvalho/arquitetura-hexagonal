package com.rafael.hexagonal.application.ports.in;


import com.rafael.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
