package com.obrunomendes.rh.funcionario.data.models.funcionario;

public enum TipoSexo {
    M("Masculino"), F("Feminino");
    String descricao;

    TipoSexo(String descricao) {
        this.descricao = descricao;
    }

    public TipoSexo toEnum(String str) {
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
