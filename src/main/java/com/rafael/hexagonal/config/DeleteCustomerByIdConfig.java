package com.rafael.hexagonal.config;

import com.rafael.hexagonal.adapter.out.DeleteCustomerByIdAdapter;
import com.rafael.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.rafael.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DeleteCustomerByIdConfig {


    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdUseCase
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdUseCase);
    }
}
