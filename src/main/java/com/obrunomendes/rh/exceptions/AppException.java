package com.obrunomendes.rh.exceptions;

import lombok.Getter;

@Getter
public abstract class AppException extends RuntimeException {

    private final ErrorMessageBuilder error;
    private final Object[] args;

    public AppException(final Throwable cause) {
        super(cause);
        this.error = ErrorMessageBuilder.builder().message(cause.getMessage()).build();
        this.args = null;
    }

    public AppException(final String error) {
        super(error);
        this.error = ErrorMessageBuilder.builder().message(error).build();
        this.args = null;
    }
}
