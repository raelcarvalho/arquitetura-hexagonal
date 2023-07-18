package com.rafael.hexagonal.application.core.usecase;

import com.rafael.hexagonal.application.core.domain.Customer;
import com.rafael.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.rafael.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.rafael.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import com.rafael.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    @Autowired
    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;

    @Autowired
    private final InsertCustomerOutPutPort insertCustomerOutPutPort;

    @Autowired
    private final SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
            InsertCustomerOutPutPort insertCustomerOutPutPort,
            SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort
    ) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
        this.sendCpfForValidationOutPutPort = sendCpfForValidationOutPutPort;
    }

    @Override
    public void insert(Customer customer, String zipcode){
        var address = findAddressByZipCodeOutPutPort.find(zipcode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
        sendCpfForValidationOutPutPort.send(customer.getCpf());
    }

}
