package com.rafael.hexagonal.adapter.out;

import com.rafael.hexagonal.adapter.out.repository.CustomerRepository;
import com.rafael.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.rafael.hexagonal.application.core.domain.Customer;
import com.rafael.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    /*
      Esse optional vai utilizar o MAP para tudo o que tiver no entity seja
      convertido para Customer e retornar.
     */
    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
