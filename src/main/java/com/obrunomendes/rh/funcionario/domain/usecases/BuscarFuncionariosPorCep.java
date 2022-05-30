package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class BuscarFuncionariosPorCep {

    final FuncionarioRepository funcionarioRepository;

    public BuscarFuncionariosPorCep(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
}
