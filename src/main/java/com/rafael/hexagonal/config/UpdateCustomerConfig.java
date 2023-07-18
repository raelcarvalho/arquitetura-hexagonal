package com.rafael.hexagonal.config;

import com.rafael.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.rafael.hexagonal.adapter.out.FindCustomerByIdAdapter;
import com.rafael.hexagonal.adapter.out.UpdateCustomerAdapter;
import com.rafael.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.rafael.hexagonal.application.core.usecase.UpdateCustomeruseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomeruseCase updateCustomeruseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomeruseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
