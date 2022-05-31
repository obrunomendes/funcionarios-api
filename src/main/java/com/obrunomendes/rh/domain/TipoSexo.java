package com.obrunomendes.rh.domain;

import lombok.Getter;

@Getter
public enum TipoSexo {
    MASCULINO("M"), FEMININO("F");
    private String descricao;

    TipoSexo(String descricao) {
        this.descricao = descricao;
    }

    public static TipoSexo toEnum(String str) {
        if (str == null) {
            throw new IllegalArgumentException("");
        }
        for (TipoSexo x : TipoSexo.values()) {
            if (x.descricao.equals(str)) {
                return x;
            }
        }
        throw new IllegalArgumentException("");
    }
}
