package com.rafael.hexagonal.application.ports.in;

import org.springframework.stereotype.Component;

@Component
public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
