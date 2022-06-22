package com.obrunomendes.rh.repositories;

import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.domain.Estado;
import com.obrunomendes.rh.domain.Funcionario;
import com.obrunomendes.rh.domain.TipoSexo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.UUID;

@DataJpaTest
class FuncionarioRepositoryTest {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    Funcionario funcionario =
            new Funcionario(null, UUID.randomUUID().toString(),
                    "funcionarioTeste",
                    LocalDate.parse("1950-03-22"),
                    TipoSexo.FEMININO, new Endereco("6500000", Estado.MA, "Centro", "São Luis"));

    @Test
    void deveSalvarFuncionario() {
        Funcionario func = funcionarioRepository.save(funcionario);

        Assertions.assertNotNull(func);
        Assertions.assertNotNull(func.getId());
        Assertions.assertNotNull(func.getMatricula());

    }

}
