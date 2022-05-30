package com.obrunomendes.rh.funcionario.domain.entities.endereco;

public class Cep {
    private final String MATCHER = "";

    private String numero;

    public Cep(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("");
        }
        this.numero = numero;
    }

    public Cep() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
