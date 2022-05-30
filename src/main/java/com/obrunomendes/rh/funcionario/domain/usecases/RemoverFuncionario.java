package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class RemoverFuncionario {

    final FuncionarioRepository funcionarioRepository;

    public RemoverFuncionario(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void execute(Integer id) {
        funcionarioRepository.removerFuncionario(id);
    }
}
