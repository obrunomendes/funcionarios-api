package com.obrunomendes.rh.funcionario.data.models.endereco;

public class Cep {

    private final String MATCHER = "";
    private String numero;

    public Cep(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("");
        }
        this.numero = numero;
    }
}
