package com.obrunomendes.rh.controller;

import com.obrunomendes.rh.models.request.FuncionarioRequest;
import com.obrunomendes.rh.models.request.FuncionarioUpdateRequest;
import com.obrunomendes.rh.models.response.FuncionarioResponse;
import com.obrunomendes.rh.services.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuncionarioResponse> buscarFuncionarioPorId(@PathVariable Integer id) {

        var response = funcionarioService.buscaFuncionarioPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioResponse>> listarFuncionarios(Pageable pageable) {

        var response = funcionarioService.listarFuncionarios(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/localizacao")
    public ResponseEntity<Page<FuncionarioResponse>> listarFuncionarios(@RequestParam String cep) {

        var response = funcionarioService.buscaFuncionariosPorCep(cep);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuncionarioResponse> cadastrarNovoFuncionario(
            @RequestBody @Valid FuncionarioRequest funcionario) {

        FuncionarioResponse response = funcionarioService.criaOuAtualizaFuncionario(funcionario);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar-informacoes")
    public ResponseEntity<FuncionarioResponse> atualizarFuncionario(
            @RequestBody @Valid FuncionarioRequest funcionario) {

        FuncionarioResponse response = funcionarioService.criaOuAtualizaFuncionario(funcionario);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/atualizar-informacoes")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarFuncionarioParcialmente(@RequestBody @Valid FuncionarioUpdateRequest funcionario) {

        funcionarioService.atualizacaoParcial(funcionario);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFuncionarioPorId(@PathVariable Integer id) {

        funcionarioService.removeFuncionarioPorId(id);
    }


}
