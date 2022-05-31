package com.obrunomendes.rh.domain;

import com.obrunomendes.rh.domain.converters.EstadoConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    private String cep;
    @Convert(converter = EstadoConverter.class)
    private Estado estado;
    private String bairro;
    private String cidade;
}
