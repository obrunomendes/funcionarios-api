package com.obrunomendes.rh.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.obrunomendes.rh.domain.TipoSexo;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class FuncionarioRequest {

    @NotBlank
    private String nome;
    @NotNull
    @JsonProperty(value = "data_nascimento")
    private LocalDate dataNascimento;
    @NotNull
    private TipoSexo sexo;

    @Valid
    private EnderecoRequest endereco;
}
