package com.obrunomendes.rh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends AppException{

    public FuncionarioNotFoundException(Throwable cause) {
        super(cause);
    }

    public FuncionarioNotFoundException(String mensagem){
        super(mensagem);
    }
}
