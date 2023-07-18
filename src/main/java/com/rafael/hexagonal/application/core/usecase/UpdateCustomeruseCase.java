package com.rafael.hexagonal.application.core.usecase;

import com.rafael.hexagonal.application.core.domain.Customer;
import com.rafael.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.rafael.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.rafael.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomeruseCase implements UpdateCustomerInputPort{

    @Autowired
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;

    @Autowired
    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;

    /*
      Regra de negocio para verificar se existe esse cliente
     */
    public UpdateCustomeruseCase (FindCustomerByIdInputPort findCustomerByIdInputPort,
                                  FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  UpdateCustomerOutPutPort updateCustomerOutPutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.updateCustomerOutPutPort = updateCustomerOutPutPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPutPort.update(customer);
    }
}
