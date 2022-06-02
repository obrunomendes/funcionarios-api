package com.obrunomendes.rh.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViaCepResponse {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

}
