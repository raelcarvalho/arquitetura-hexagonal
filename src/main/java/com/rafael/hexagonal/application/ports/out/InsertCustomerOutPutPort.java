package com.rafael.hexagonal.application.ports.out;

import com.rafael.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerOutPutPort {

    void insert(Customer customer);
}
