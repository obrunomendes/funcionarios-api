package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class AtualizarFuncionario {
    final FuncionarioRepository funcionarioRepository;

    public AtualizarFuncionario(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
}
