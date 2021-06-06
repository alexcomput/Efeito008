package br.com.ecommit.efeitoAp008.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Setter
@Getter
@ConfigurationProperties("ap008")
public class Ap008Properties {

    @NotNull
    private String input;

    @NotNull
    private String output;
}
