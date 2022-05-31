package com.obrunomendes.rh.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.obrunomendes.rh.domain.TipoSexo;
import com.obrunomendes.rh.exceptions.messages.ErrorMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class FuncionarioUpdateRequest {

    @NotNull(message = ErrorMessage.REQUIRED_FIELD)
    private Integer id;

    private String nome;

    @JsonProperty(value = "data_nascimento")
    private LocalDate dataNascimento;

    private TipoSexo sexo;

    private EnderecoRequest endereco;

}
