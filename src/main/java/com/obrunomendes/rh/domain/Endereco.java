package com.obrunomendes.rh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    private String cep;
    private Estado estado;
    private String bairro;
    private String cidade;
}
