package com.obrunomendes.rh.funcionario.data.datasources;

public interface FuncionarioDatasources {

    void cadastrarFuncionario();

    void buscarFuncionarioPeloId();

    void buscarTodosOsFuncionarios();

    void buscarUsuariosPorCEP();

    void atualizarFuncionario();

    void removerFuncionario();

}
