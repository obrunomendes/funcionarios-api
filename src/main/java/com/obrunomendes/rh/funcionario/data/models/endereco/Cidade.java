package com.obrunomendes.rh.funcionario.data.models.endereco;

public class Cidade {

    private String nome;

    public Cidade(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("");
        }
        this.nome = nome;
    }
}
