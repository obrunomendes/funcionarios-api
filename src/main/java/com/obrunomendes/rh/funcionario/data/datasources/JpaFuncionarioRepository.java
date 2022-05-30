package com.obrunomendes.rh.funcionario.data.datasources;

import com.obrunomendes.rh.funcionario.data.models.funcionario.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaFuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    // adicionado apenas para teste
    //TODO: remover
    List<FuncionarioModel> findAllByCep(String cep);

}
