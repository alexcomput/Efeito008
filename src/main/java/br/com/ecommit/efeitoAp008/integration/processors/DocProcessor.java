package br.com.ecommit.efeitoAp008.integration.processors;

import br.com.ecommit.efeitoAp008.integration.dto.EfeitoDTO;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("DocProcessor")
public class DocProcessor implements PaymentProcessor{

    @Override
    public void process(Exchange exchange) throws Exception {

        EfeitoDTO payment = exchange.getIn().getBody(EfeitoDTO.class);
        System.out.println("Running doc processor. payload: " + payment.toString());
    }
}
