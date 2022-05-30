package com.obrunomendes.rh.funcionario.domain.entities.endereco;

public class Endereco {

    private Cep cep;
    private Estado estado;
    private String cidade;
    private String bairro;

    public Endereco(Cep cep,  String cidade, String bairro) {
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
    }
    public Endereco(){}

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
