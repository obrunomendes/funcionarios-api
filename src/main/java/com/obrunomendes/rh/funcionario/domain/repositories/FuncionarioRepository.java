package com.obrunomendes.rh.funcionario.domain.repositories;

import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    public Funcionario cadastrarFuncionario(Funcionario funcionario);

    public Optional<Funcionario> buscarFuncionarioPeloId(Integer id);

    public List<Funcionario> buscarTodosOsFuncionarios();

    public List<Funcionario> buscarFuncionariosPorCEP(String cep);

    public void atualizarFuncionario(Funcionario funcionario);

    public void removerFuncionario(Integer id);

}
