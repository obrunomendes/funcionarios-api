package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;
import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class BuscarFuncionarioPeloId {

    final FuncionarioRepository funcionarioRepository;

    public BuscarFuncionarioPeloId(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario execute(Integer id) {
        return funcionarioRepository.buscarFuncionarioPeloId(id).orElseThrow(() -> new RuntimeException("Deu ruim"));
    }

}
