package com.rafael.hexagonal.adapter.in.controller.response;

import com.rafael.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;

    private boolean isValidCpf;

}
