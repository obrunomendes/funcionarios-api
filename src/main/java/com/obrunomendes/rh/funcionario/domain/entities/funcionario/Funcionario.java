package com.obrunomendes.rh.funcionario.domain.entities.funcionario;

import com.obrunomendes.rh.funcionario.domain.entities.endereco.Endereco;

public class Funcionario {

    private String nome;
    private Integer idade;
    private TipoSexo sexo;
    private Endereco endereco;

    public Funcionario(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Funcionario(String nome, Integer idade, TipoSexo sexo, Endereco endereco) {
        this(nome, idade);
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
