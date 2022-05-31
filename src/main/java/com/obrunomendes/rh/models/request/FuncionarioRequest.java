package com.obrunomendes.rh.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.obrunomendes.rh.domain.TipoSexo;
import com.obrunomendes.rh.exceptions.messages.ErrorMessage;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class FuncionarioRequest {

    @NotBlank
    private String nome;

    @NotNull(message = ErrorMessage.REQUIRED_FIELD)
    @JsonProperty(value = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = ErrorMessage.REQUIRED_FIELD)
    private TipoSexo sexo;

    @NotNull(message = ErrorMessage.REQUIRED_FIELD)
    @Valid
    private EnderecoRequest endereco;

}
