package com.rafael.hexagonal.adapter.in.controller.mapper;


import com.rafael.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.rafael.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.rafael.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

}
