package com.rafael.hexagonal.application.ports.in;


import com.rafael.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
