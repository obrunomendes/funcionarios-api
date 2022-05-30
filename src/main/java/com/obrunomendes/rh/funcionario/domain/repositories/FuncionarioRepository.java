package com.obrunomendes.rh.funcionario.domain.repositories;

public interface FuncionarioRepository {

    void cadastrarFuncionario();

    void buscarFuncionarioPeloId();

    void buscarTodosOsFuncionarios();

    void buscarUsuariosPorCEP();

    void atualizarFuncionario();

    void removerFuncionario();

}
