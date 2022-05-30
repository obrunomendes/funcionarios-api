package com.obrunomendes.rh.funcionario.data.datasources;

import com.obrunomendes.rh.funcionario.data.models.endereco.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEnderecoRepository extends JpaRepository<EnderecoModel, Integer> {
}
