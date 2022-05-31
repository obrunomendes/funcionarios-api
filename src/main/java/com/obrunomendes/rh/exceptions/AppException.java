package com.obrunomendes.rh.exceptions;

public abstract class AppException extends RuntimeException{

    private final ErrorMessageBuilder error;
    private final Object[] args;

    public AppException(final Throwable cause) {
        super(cause);
        this.error = ErrorMessageBuilder.builder().message(cause.getMessage()).build();
        this.args = null;
    }
}
