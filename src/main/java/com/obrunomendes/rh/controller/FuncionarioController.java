package com.obrunomendes.rh.controller;

import com.obrunomendes.rh.models.request.FuncionarioRequest;
import com.obrunomendes.rh.models.response.FuncionarioResponse;
import com.obrunomendes.rh.services.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuncionarioResponse> cadastraNovoFuncionario(@RequestBody FuncionarioRequest funcionario) {
        FuncionarioResponse response = funcionarioService.novoFuncionario(funcionario);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuncionarioResponse> buscaFuncionarioPorId(@PathVariable Integer id) {
        funcionarioService.buscaFuncionarioPorId(id);
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioResponse>> listarFuncionarios(Pageable pageable) {
        funcionarioService.listarFuncionarios(pageable);
        return null;
    }

    @GetMapping("/localizacao")
    public ResponseEntity<Page<FuncionarioResponse>> listarFuncionarios(@RequestParam String cep) {
        funcionarioService.buscaFuncionariosPorCep(cep);
        return null;
    }

}
