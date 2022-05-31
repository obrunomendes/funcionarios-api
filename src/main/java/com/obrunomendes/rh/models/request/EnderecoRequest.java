package com.obrunomendes.rh.models.request;

import com.obrunomendes.rh.exceptions.messages.ErrorMessage;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class EnderecoRequest {

    @NotBlank(message = ErrorMessage.REQUIRED_FIELD)
    @Pattern(regexp = "(^\\d{5}-\\d{3}|^\\d{2}.\\d{3}-\\d{3}|\\d{8})",
            message = ErrorMessage.INVALID_CEP_PATTERN)
    private String cep;

    @Size(min = 2, max = 2, message = ErrorMessage.INVALID_ESTADO_MIN_MAX)
    private String estado;

    private String bairro;

    private String cidade;
}
