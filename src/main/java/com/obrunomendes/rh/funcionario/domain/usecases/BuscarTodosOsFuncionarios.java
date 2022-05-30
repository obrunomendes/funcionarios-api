package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class BuscarTodosOsFuncionarios {

    final FuncionarioRepository funcionarioRepository;

    public BuscarTodosOsFuncionarios(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
}
