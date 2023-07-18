package com.rafael.hexagonal.adapter.out;

import com.rafael.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutPutPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /*
      Envia o CPF para o topico kafka
     */
    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);

    }
}
