package br.com.ecommit.efeitoAp008.application.domain.payment.commons;

import br.com.ecommit.efeitoAp008.application.domain.payment.commons.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class Payer implements Serializable {

    private static final long serialVersionUID = 1963385643368678314L;

    private UUID id;

    private String name;

    private String account;

    private String agency;

    private AccountType accountType;
}
