package com.rafael.hexagonal.adapter.out;

import com.rafael.hexagonal.adapter.out.client.FindAddressByZipCodeClient;
import com.rafael.hexagonal.adapter.out.client.Mapper.AddressResponseMapper;
import com.rafael.hexagonal.application.core.domain.Address;
import com.rafael.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPutPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode){
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
