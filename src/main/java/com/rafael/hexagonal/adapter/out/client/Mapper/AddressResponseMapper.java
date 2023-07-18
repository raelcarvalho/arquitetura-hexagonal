package com.rafael.hexagonal.adapter.out.client.Mapper;

import com.rafael.hexagonal.adapter.out.client.Response.AddressResponse;
import com.rafael.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);


}
