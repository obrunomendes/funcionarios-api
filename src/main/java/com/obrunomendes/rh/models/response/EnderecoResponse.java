package com.obrunomendes.rh.models.response;

import lombok.Data;

@Data
public class EnderecoResponse {

    private String cep;
    private String estado;
    private String bairro;
    private String cidade;
}
