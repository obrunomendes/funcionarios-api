package com.obrunomendes.rh.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@ControllerAdvice
public class AppExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(AppException.class)
    protected ResponseEntity<ErrorMessageBuilder> processAPIException(final AppException ex) {
        final ResponseStatus status = ex.getClass().getDeclaredAnnotation(ResponseStatus.class);
        LOGGER.error("Error:{}", ex);

        final String message = translateMessageAndArgs(ex.getError().getMessage(), ex.getArgs());

        return new ResponseEntity<>(
                ErrorMessageBuilder.builder().message(message).errors(Arrays.asList(message)).build(),
                Objects.nonNull(status) ? status.code() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String translateMessageAndArgs(final String message, final Object... args) {
        return Optional.ofNullable(messageSource.getMessage(message, args, message, Locale.getDefault())).orElse(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageBuilder> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        LOGGER.error("Error:{}", ex);

        final ErrorMessageBuilder errorMessage = ErrorMessageBuilder.builder().message("Invalid Request").build();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessage.addError(getMessage(error));

        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    private String getMessage(final ObjectError objectError) {
        final String code = objectError.getDefaultMessage();
        final Object[] args = objectError.getArguments();
        return messageSource.getMessage(code, args, code, Locale.getDefault());
    }
}
