package com.rafael.hexagonal.config;

import com.rafael.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.rafael.hexagonal.adapter.out.InsertCustomerAdapter;
import com.rafael.hexagonal.adapter.out.SendCpfValidationAdapter;
import com.rafael.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
