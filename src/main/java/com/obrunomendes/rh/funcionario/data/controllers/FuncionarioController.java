package com.obrunomendes.rh.funcionario.data.controllers;

import com.obrunomendes.rh.funcionario.domain.entities.funcionario.Funcionario;
import com.obrunomendes.rh.funcionario.domain.usecases.BuscarFuncionarioPeloId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    final BuscarFuncionarioPeloId buscarFuncionarioPeloId;

    public FuncionarioController(BuscarFuncionarioPeloId buscarFuncionarioPeloId) {
        this.buscarFuncionarioPeloId = buscarFuncionarioPeloId;
    }

    @GetMapping
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscaPorId(@PathVariable Integer id) {
        Funcionario funcionario = buscarFuncionarioPeloId.execute(id);
        return ResponseEntity.ok(funcionario);
    }

}
