package com.obrunomendes.rh.funcionario.data.datasources;

import com.obrunomendes.rh.funcionario.data.models.funcionario.FuncionarioModel;

import java.util.List;
import java.util.Optional;

public interface FuncionarioDatasources {

    FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionarioModel);

    Optional<FuncionarioModel> buscarFuncionarioPeloId(Integer id);

    List<FuncionarioModel> buscarTodosOsFuncionarios();

    List<FuncionarioModel> buscarFuncionariosPorCEP(String cep);

    void atualizarFuncionario(FuncionarioModel funcionarioModel);

    void removerFuncionario(Integer id);

}
