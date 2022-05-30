package com.obrunomendes.rh.funcionario.data.repositories;

import com.obrunomendes.rh.funcionario.data.datasources.FuncionarioDatasources;
import com.obrunomendes.rh.funcionario.data.models.funcionario.FuncionarioModel;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositoryImpl {
    final FuncionarioDatasources funcionarioDatasources;

    FuncionarioRepositoryImpl(FuncionarioDatasources funcionarioDatasources) {
        this.funcionarioDatasources = funcionarioDatasources;
    }


    public FuncionarioModel cadastrarFuncionario() {
        return null;
    }


    public Optional<FuncionarioModel> buscarFuncionarioPeloId() {
        return Optional.empty();
    }


    public List<FuncionarioModel> buscarTodosOsFuncionarios() {
        return null;
    }


    public List<FuncionarioModel> buscarUsuariosPorCEP() {
        return null;
    }


    public void atualizarFuncionario() {

    }

    public void removerFuncionario() {

    }
}
