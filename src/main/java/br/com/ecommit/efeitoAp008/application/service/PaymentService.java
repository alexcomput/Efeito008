package br.com.ecommit.efeitoAp008.application.service;

import br.com.ecommit.efeitoAp008.integration.dto.EfeitoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("personService")
@RequiredArgsConstructor
public class PaymentService {

    public void validate() {

        System.out.println("validating: " );
    }

    public void store(EfeitoDTO payment) {
        System.out.println("storing new ted: " + payment.toString());
    }
}
