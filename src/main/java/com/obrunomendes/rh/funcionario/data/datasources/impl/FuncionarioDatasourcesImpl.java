package com.obrunomendes.rh.funcionario.data.datasources.impl;

import com.obrunomendes.rh.funcionario.data.datasources.FuncionarioDatasources;
import com.obrunomendes.rh.funcionario.data.datasources.JpaFuncionarioRepository;
import com.obrunomendes.rh.funcionario.data.models.funcionario.FuncionarioModel;

import java.util.List;
import java.util.Optional;

public class FuncionarioDatasourcesImpl implements FuncionarioDatasources {
    private final JpaFuncionarioRepository jpaFuncionarioRepository;

    public FuncionarioDatasourcesImpl(JpaFuncionarioRepository jpaFuncionarioRepository) {
        this.jpaFuncionarioRepository = jpaFuncionarioRepository;
    }

    @Override
    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionarioModel) {
        return jpaFuncionarioRepository.save(funcionarioModel);
    }

    @Override
    public Optional<FuncionarioModel> buscarFuncionarioPeloId(Integer id) {
        return jpaFuncionarioRepository.findById(id);
    }

    @Override
    public List<FuncionarioModel> buscarTodosOsFuncionarios() {
        return jpaFuncionarioRepository.findAll();
    }

    @Override
    public List<FuncionarioModel> buscarFuncionariosPorCEP(String cep) {
        return jpaFuncionarioRepository.findAllByEnderecoModel_Cep(cep);
    }

    @Override
    public void atualizarFuncionario(FuncionarioModel funcionarioModel) {
        jpaFuncionarioRepository.save(funcionarioModel);
    }

    @Override
    public void removerFuncionario(Integer id) {
        jpaFuncionarioRepository.deleteById(id);
    }

}
