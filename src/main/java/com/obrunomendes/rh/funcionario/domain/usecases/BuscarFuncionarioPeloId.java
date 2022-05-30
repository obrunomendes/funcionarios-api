package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class BuscarFuncionarioPeloId {

    final FuncionarioRepository funcionarioRepository;

    public BuscarFuncionarioPeloId(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void execute(Integer id) {
        funcionarioRepository.buscarFuncionarioPeloId(id);
    }

}
