package com.obrunomendes.rh.funcionario.domain.repositories;

import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    Funcionario cadastrarFuncionario(Funcionario funcionario);

    Optional<Funcionario> buscarFuncionarioPeloId(Integer id);

    List<Funcionario> buscarTodosOsFuncionarios();

    List<Funcionario> buscarFuncionariosPorCEP(String cep);

    void atualizarFuncionario(Funcionario funcionario);

    void removerFuncionario(Integer id);

}
