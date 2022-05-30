package com.obrunomendes.rh.funcionario.data.repositories;

import com.obrunomendes.rh.funcionario.data.datasources.FuncionarioDatasources;
import com.obrunomendes.rh.funcionario.data.models.funcionario.FuncionarioModel;
import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;
import com.obrunomendes.rh.funcionario.domain.repositories.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositoryImpl implements FuncionarioRepository {
    final FuncionarioDatasources funcionarioDatasources;

    FuncionarioRepositoryImpl(FuncionarioDatasources funcionarioDatasources) {
        this.funcionarioDatasources = funcionarioDatasources;
    }


    @Override
    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return null;
    }

    @Override
    public Optional<Funcionario> buscarFuncionarioPeloId(Integer id) {
        //TODO: alterar essa implementacao - feita para teste
        FuncionarioModel fm = funcionarioDatasources.buscarFuncionarioPeloId(id).orElseThrow();
        Funcionario func = new Funcionario();
        func.setNome(fm.getNome());
        func.setIdade(fm.getIdade());
        return Optional.of(func);
    }

    @Override
    public List<Funcionario> buscarTodosOsFuncionarios() {
        return null;
    }

    @Override
    public List<Funcionario> buscarFuncionariosPorCEP(String cep) {
        return null;
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {

    }

    @Override
    public void removerFuncionario(Integer id) {

    }
}
