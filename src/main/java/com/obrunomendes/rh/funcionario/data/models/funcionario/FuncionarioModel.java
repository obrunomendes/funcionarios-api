package com.obrunomendes.rh.funcionario.data.models.funcionario;

import com.obrunomendes.rh.funcionario.data.models.endereco.EnderecoModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private String sexo;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private EnderecoModel enderecoModel;

    public FuncionarioModel(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public FuncionarioModel(String nome, Integer idade, String sexo, EnderecoModel enderecoModel) {
        this(nome, idade);
        this.sexo = sexo;
        this.enderecoModel = enderecoModel;
    }

    public Integer getId() {
        return id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public EnderecoModel getEndereco() {
        return enderecoModel;
    }

    public void setEndereco(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }
}
