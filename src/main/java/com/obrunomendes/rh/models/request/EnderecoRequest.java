package com.obrunomendes.rh.models.request;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class EnderecoRequest {

    @Pattern(regexp = "(^\\\\d{5}-\\\\d{3}|^\\\\d{2}.\\\\d{3}-\\\\d{3}|\\\\d{8})")
    private String cep;
    @Size(min = 2, max = 2)
    private String estado;
    private String bairro;
    private String cidade;
}
