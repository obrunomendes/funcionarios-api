package com.obrunomendes.rh.funcionario.data.datasources.impl;

import com.obrunomendes.rh.funcionario.data.datasources.FuncionarioDatasources;
import com.obrunomendes.rh.funcionario.data.datasources.JpaFuncionarioRepository;
import com.obrunomendes.rh.funcionario.data.models.funcionario.FuncionarioModel;

import java.util.List;
import java.util.Optional;

public class FuncionarioDatasourcesImpl implements FuncionarioDatasources {
    private final JpaFuncionarioRepository funcionarioRepository;

    public FuncionarioDatasourcesImpl(JpaFuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);
    }

    @Override
    public Optional<FuncionarioModel> buscarFuncionarioPeloId(Integer id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public List<FuncionarioModel> buscarTodosOsFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public List<FuncionarioModel> buscarFuncionariosPorCEP(String cep) {
        return funcionarioRepository.findAllByCep(cep);
    }

    @Override
    public void atualizarFuncionario(FuncionarioModel funcionarioModel) {
        funcionarioRepository.save(funcionarioModel);
    }

    @Override
    public void removerFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
    }

}
