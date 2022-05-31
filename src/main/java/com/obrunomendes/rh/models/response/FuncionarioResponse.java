package com.obrunomendes.rh.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.domain.TipoSexo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioResponse {

    private String matricula;
    private String nome;
    @JsonProperty(value = "data_nascimento")
    private LocalDate dataNascimento;
    private TipoSexo sexo;
    private Endereco endereco;


}
