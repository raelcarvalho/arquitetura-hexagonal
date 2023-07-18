package com.rafael.hexagonal.adapter.out;

import com.rafael.hexagonal.adapter.out.repository.CustomerRepository;
import com.rafael.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.rafael.hexagonal.application.core.domain.Customer;
import com.rafael.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }

}
