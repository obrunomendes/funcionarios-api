package com.obrunomendes.rh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoNotFoundException extends AppException{

    public EnderecoNotFoundException(Throwable cause) {
        super(cause);
    }

    public EnderecoNotFoundException(String mensagem){
        super(mensagem);
    }
}
