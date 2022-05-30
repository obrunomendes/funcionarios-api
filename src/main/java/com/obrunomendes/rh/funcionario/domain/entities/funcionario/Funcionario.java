package com.obrunomendes.rh.funcionario.domain.entities.funcionario;

import com.obrunomendes.rh.funcionario.domain.entities.endereco.Endereco;

public class Funcionario {

    private String nome;
    private Integer idade;
    private Endereco endereco;
    private TipoSexo tipoSexo;

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

    public TipoSexo getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(TipoSexo sexo) {
        this.tipoSexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
