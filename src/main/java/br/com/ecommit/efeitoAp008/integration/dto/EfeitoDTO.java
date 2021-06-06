package br.com.ecommit.efeitoAp008.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@CsvRecord(separator = ";", skipField = true, skipFirstLine = true)
public class EfeitoDTO implements Serializable {

    private static final long serialVersionUID = -6717078795535897380L;

    @DataField(pos = 1)
    private String cpnjLinx;

    @DataField(pos = 2)
    private int fumaca;

    @DataField(pos = 3)
    private String cpnjEstabelecimentio;

    @DataField(pos = 4)
    private String arranjo;

    @DataField(pos = 5)
    private LocalDate dataLiquidacao;

    private List<Efeito> efeitos;


    public EfeitoDTO(String[] s1, String[] efeitos) {
        this.setCpnjLinx(s1[0]);
        this.setFumaca(Integer.parseInt(s1[1]));
        this.setCpnjEstabelecimentio(s1[2]);
        this.setArranjo(s1[3]);
        this.setDataLiquidacao(LocalDate.parse(s1[4]));
        //Tratar o efeito
        this.setEfeitos(tratarEfeito(efeitos));

    }

    private List<Efeito> tratarEfeito(String[] efeitos) {
        ArrayList<Efeito> listEfeitos = new ArrayList<>();
        Arrays.stream(efeitos).forEach(eft -> {

            String[] de = eft.split(";");

            Efeito efeito = new Efeito();

            //Indicador de efeitos
            efeito.setIndicadorEfeito(Integer.parseInt(de[1]));
            //Entidade registradora
            efeito.setEntidadeRegistradora(de[2]);
            //Regras de divisão
            efeito.setRegraDivisao(Integer.parseInt(de[5]));
            //Valor comprometido
            efeito.setValorComprometido(BigDecimal.valueOf(Long.parseLong(de[6])));
            //Número documento titular domicílio
            efeito.setDocumentoTitularDomicilio(de[7]);
            //Tipo cnta
            efeito.setTipoConta(de[8]);
            //COMPE
            efeito.setCompe(de[9]);
            //ISPB
            efeito.setIspb(de[10]);
            //Agência
            efeito.setAgencia(de[11]);
            //Numero conta
            efeito.setNumeroConta(de[12].replace("\"", ""));
            listEfeitos.add(efeito);

        });
        return listEfeitos;
    }

    @Setter
    @Getter
    public class Efeito {

        private int indicadorEfeito;

        private String entidadeRegistradora;

        private int regraDivisao;

        private BigDecimal valorComprometido;

        private String documentoTitularDomicilio;

        private String tipoConta;

        private String compe;

        private String ispb;

        private String agencia;

        private String numeroConta;

    }

    @Override
    public String toString() {
        return "EfeitoDTO{" +
                "cpnjLinx='" + cpnjLinx + '\'' +
                ", fumaca=" + fumaca +
                ", cpnjEstabelecimentio='" + cpnjEstabelecimentio + '\'' +
                ", arranjo='" + arranjo + '\'' +
                ", dataLiquidacao=" + dataLiquidacao +
                ", efeitos=" + efeitos +
                '}';
    }
}
