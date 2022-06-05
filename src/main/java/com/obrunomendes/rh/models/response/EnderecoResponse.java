package com.obrunomendes.rh.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoResponse {

    private String cep;
    private String estado;
    private String bairro;
    private String cidade;
}
