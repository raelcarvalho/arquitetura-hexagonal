package com.rafael.hexagonal.adapter.in.consumer.mapper;


import com.rafael.hexagonal.adapter.in.consumer.message.CustomerMessage;
import com.rafael.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
