package com.obrunomendes.rh.funcionario.domain.usecases;

import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;
import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

public class CadastrarFuncionario {

    final FuncionarioRepository funcionarioRepository;

    public CadastrarFuncionario(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void execute(Funcionario funcionario) {
        funcionarioRepository.cadastrarFuncionario(funcionario);
    }
}
