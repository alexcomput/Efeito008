package br.com.ecommit.efeitoAp008.process;


import br.com.ecommit.efeitoAp008.integration.dto.EfeitoDTO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
@Qualifier("Ap008Processor")
public class Ap008Processor implements EfetosProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        HashMap<String, EfeitoDTO> map = new HashMap<>();

        List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
        sumarizarEc(data, map);
        StringBuilder csv = new StringBuilder();
        map.forEach((s, efeitoDTO) -> {
            efeitoDTO.getEfeitos().forEach(eft -> {
                csv.append(efeitoDTO.getCpnjLinx());
                csv.append(";");
                csv.append(efeitoDTO.getFumaca());
                csv.append(";");
                csv.append(efeitoDTO.getCpnjEstabelecimentio());
                csv.append(";");
                csv.append(efeitoDTO.getArranjo());
                csv.append(";");
                csv.append(efeitoDTO.getDataLiquidacao());
                csv.append(";");
                csv.append(eft.getIndicadorEfeito());
                csv.append(";");
                csv.append(eft.getEntidadeRegistradora());
                csv.append(";");
                csv.append(eft.getRegraDivisao());
                csv.append(";");
                csv.append(eft.getValorComprometido());
                csv.append(";");
                csv.append(eft.getDocumentoTitularDomicilio());
                csv.append(";");
                csv.append(eft.getTipoConta());
                csv.append(";");
                csv.append(eft.getCompe());
                csv.append(";");
                csv.append(eft.getIspb());
                csv.append(";");
                csv.append(eft.getAgencia());
                csv.append(";");
                csv.append(eft.getNumeroConta());
                csv.append("\n");
            });
        });
        exchange.getIn().setBody(csv.toString());

    }

    private void sumarizarEc(List<List<String>> data, HashMap<String, EfeitoDTO> map) {
        data.forEach(res -> {
            res.forEach(s -> {
                String[] efeitos = s.substring(62).replace("|", "ø").split("ø");
                String[] s1 = s.substring(0, 62).split(";");
                if (s1[1].equals("2")) {
                    StringBuilder chave = new StringBuilder();
                    chave.append(s1[0]);
                    chave.append(s1[1]);
                    chave.append(s1[2]);
                    chave.append(s1[3]);

                    EfeitoDTO efeitoDTO = new EfeitoDTO(s1, efeitos);
                    //Pegando os efeitos apenas de amanhã
                    if (LocalDate.now().plusDays(1).equals(efeitoDTO.getDataLiquidacao())) {
                        if (!efeitoDTO.getEfeitos().isEmpty()) {
                            if (map.containsKey(chave.toString())) {
                                EfeitoDTO efeitoEnt = map.get(chave.toString());
                                if (efeitoEnt.getDataLiquidacao().isAfter(efeitoDTO.getDataLiquidacao())) {
                                    map.put(chave.toString(), efeitoDTO);
                                }
                            } else {
                                map.put(chave.toString(), efeitoDTO);
                            }
                        }
                    }
                }
            });
        });
    }
}
