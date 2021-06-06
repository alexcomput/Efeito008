package br.com.ecommit.efeitoAp008.route;

import br.com.ecommit.efeitoAp008.Ap008Route;
import br.com.ecommit.efeitoAp008.application.service.PaymentService;
import br.com.ecommit.efeitoAp008.process.Ap008Processor;
import br.com.ecommit.efeitoAp008.util.CsvRecordToPersonMapper;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringCamelRoute extends RouteBuilder {


    private static final String QUESTION_MARK = "?";
    private static final String AMPERSAND = "&";
    private static final String COLON = ":";
    private final Environment env;

    private final CsvRecordToPersonMapper mapper;
    private final Ap008Processor ap008Processor;
    private final PaymentService paymentService;
    private final Ap008Route route;

    @Override
    public void configure() {


        try {
                CamelContext context = new DefaultCamelContext();
                context.setStreamCaching(false);
                route.addRoutesToCamelContext(context);
                context.start();
                Thread.sleep(5000);
                context.stop();
        } catch (Exception exe) {
            //logger.info(exe.getMessage());
            exe.printStackTrace();
        }

    }

}