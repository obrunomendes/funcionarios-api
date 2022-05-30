package com.obrunomendes.rh.funcionario.data.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @GetMapping
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().build();
    }
}
