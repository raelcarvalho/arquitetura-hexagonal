package com.rafael.hexagonal.application.core.usecase;

import com.rafael.hexagonal.application.core.domain.Customer;
import com.rafael.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    @Autowired
    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort){
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    /*
      Metodo para excessão caso não consiga encontrar o cliente por id
     */
    @Override
    public Customer find(String id){
        return findCustomerByIdOutPutPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
