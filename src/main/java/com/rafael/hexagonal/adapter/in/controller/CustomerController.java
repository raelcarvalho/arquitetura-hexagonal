package com.rafael.hexagonal.adapter.in.controller;

import com.rafael.hexagonal.adapter.in.controller.mapper.CustomerMapper;
import com.rafael.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.rafael.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.rafael.hexagonal.application.core.domain.Customer;
import com.rafael.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.rafael.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.rafael.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;


    /*
      O tipo <Void> é colocado pq não será retornado nada
      - O retorno noContent é para retornar 204 para API caso dê erro.
     */
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    /*
      Endpoint para fazer update das informações do cliente
      - CustomerResquest não tem ID, então pegamos no Customer e settamos ele
      - O Customer não tem o ZipCode, então settamos o CustomerRequest para pegar o ZipCode
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    /*
      O tipo <Void> é colocado pq não será retornado nada
      - O retorno noContent é para retornar 204 para API caso dê erro.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
