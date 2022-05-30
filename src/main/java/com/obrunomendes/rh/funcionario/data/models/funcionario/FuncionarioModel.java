package com.obrunomendes.rh.funcionario.data.models.funcionario;

import com.obrunomendes.rh.funcionario.data.models.endereco.EnderecoModel;
import com.obrunomendes.rh.funcionario.domain.entities.endereco.Cep;
import com.obrunomendes.rh.funcionario.domain.entities.endereco.Endereco;
import com.obrunomendes.rh.funcionario.domain.entities.endereco.Estado;
import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;

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
    private String tipoSexo;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private EnderecoModel enderecoModel;

    public FuncionarioModel() {
    }

    public FuncionarioModel(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public FuncionarioModel(String nome, Integer idade, String tipoSexo, EnderecoModel enderecoModel) {
        this(nome, idade);
        this.tipoSexo = tipoSexo;
        this.enderecoModel = enderecoModel;
    }

    public Funcionario conveteParaFuncionario(FuncionarioModel fm) {
        Endereco em = null;
        if (fm.enderecoModel != null) {
            em = enderecoBuilder(fm.getEndereco());
        }
        Funcionario func = new Funcionario();
        func.setNome(fm.getNome());
        func.setIdade(fm.getIdade());
        func.setEndereco(em);
        return func;
    }

    public FuncionarioModel converteParaFuncionarioModel(Funcionario func) {
        EnderecoModel em = null;
        if (func.getEndereco() != null) {
            em = enderecoBuilder(func.getEndereco());
        }

        FuncionarioModel fm = new FuncionarioModel();
        fm.setNome(func.getNome());
        fm.setIdade(func.getIdade());
        fm.setEndereco(em);
        return fm;
    }

    private Endereco enderecoBuilder(EnderecoModel em) {
        Endereco endereco = new Endereco();
        endereco.setBairro(em.getBairro());
        endereco.setCep(new Cep(em.getCep()));
        endereco.setEstado(Estado.toEnum(em.getEstado()));
        endereco.setCidade(em.getCidade());
        return endereco;
    }

    private EnderecoModel enderecoBuilder(Endereco endereco) {
        EnderecoModel em = new EnderecoModel();
        em.setBairro(endereco.getBairro());
        em.setCep(endereco.getCep().getNumero());
        em.setEstado(em.getEstado());
        em.setCidade(endereco.getCidade());
        return em;
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

    public String getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(String sexo) {
        this.tipoSexo = sexo;
    }

    public EnderecoModel getEndereco() {
        return enderecoModel;
    }

    public void setEndereco(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }
}
