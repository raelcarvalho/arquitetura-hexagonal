package com.rafael.hexagonal.adapter.out.repository.mapper;

import com.rafael.hexagonal.adapter.out.repository.entity.CustomerEntity;
import com.rafael.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {


    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
