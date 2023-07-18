package com.rafael.hexagonal.application.ports.out;

import com.rafael.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface FindCustomerByIdOutPutPort {

    Optional<Customer> find(String id);
}
