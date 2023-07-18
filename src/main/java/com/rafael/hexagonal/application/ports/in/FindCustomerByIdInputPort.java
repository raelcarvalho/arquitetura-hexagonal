package com.rafael.hexagonal.application.ports.in;


import com.rafael.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
