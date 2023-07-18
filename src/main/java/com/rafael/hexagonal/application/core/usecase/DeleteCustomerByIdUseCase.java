package com.rafael.hexagonal.application.core.usecase;

import com.rafael.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.rafael.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    @Autowired
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;


    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutPutPort = deleteCustomerByIdOutPutPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutPutPort.delete(id);
    }
}
