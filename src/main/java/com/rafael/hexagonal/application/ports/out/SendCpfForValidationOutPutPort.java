package com.rafael.hexagonal.application.ports.out;

import org.springframework.stereotype.Component;

@Component
public interface SendCpfForValidationOutPutPort {

    void send(String cpf);
}
