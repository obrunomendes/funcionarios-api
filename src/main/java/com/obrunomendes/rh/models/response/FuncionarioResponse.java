package com.obrunomendes.rh.models.response;

import com.obrunomendes.rh.domain.Estado;
import com.obrunomendes.rh.domain.TipoSexo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioResponse {

    private String matricula;
    private String nome;
    private LocalDate idade;
    private TipoSexo sexo;
    private Estado estado;


}
