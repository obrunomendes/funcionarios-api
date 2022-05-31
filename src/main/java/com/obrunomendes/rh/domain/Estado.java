package com.obrunomendes.rh.domain;

import lombok.Getter;

@Getter
public enum Estado {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private String descricao;

    private Estado(String descricao) {
        this.descricao = descricao;
    }

    public static Estado toEnum(String str) {
        if (str == null) {
            throw new IllegalArgumentException("");
        }
        for (Estado x : Estado.values()) {
            if (x.descricao.equals(str)) {
                return x;
            }
        }
        throw new IllegalArgumentException("");
    }
}
