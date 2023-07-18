package com.rafael.hexagonal.application.ports.out;

import com.rafael.hexagonal.application.core.domain.Address;
import org.springframework.stereotype.Component;

@Component
public interface FindAddressByZipCodeOutPutPort {

    Address find(String zipcode);

}
