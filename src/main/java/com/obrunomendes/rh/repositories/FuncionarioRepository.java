package com.obrunomendes.rh.repositories;

import com.obrunomendes.rh.domain.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
    Page<Funcionario> findAllByEndereco_Cep(String cep, Pageable pageable);
}
