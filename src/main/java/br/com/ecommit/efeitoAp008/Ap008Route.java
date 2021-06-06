package br.com.ecommit.efeitoAp008;

import br.com.ecommit.efeitoAp008.config.Ap008Properties;
import br.com.ecommit.efeitoAp008.integration.dto.EfeitoDTO;
import br.com.ecommit.efeitoAp008.process.Ap008Processor;
import br.com.ecommit.efeitoAp008.util.ArrayListAggregationStrategy;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Ap008Route {

    private final Ap008Properties ap008Properties;

    private final Ap008Processor ap008Processor;

    public void addRoutesToCamelContext(CamelContext context) throws Exception {

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                try {
                    from("file:input/?fileName=AP008.csv/?noop=true").
                        unmarshal().csv()
                        .process(ap008Processor)
                    .to("file:output?fileName=AP008a.csv");

/*

                    from(String.format("file-watch:%s/?noop=true", ap008Properties.getInput())).
                            unmarshal().csv()
                            .process(ap008Processor)
                            .to(String.format("file:%s?", ap008Properties.getOutput()));
*/

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
