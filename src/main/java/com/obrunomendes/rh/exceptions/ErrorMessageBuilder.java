package com.obrunomendes.rh.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorMessageBuilder {

    private String message;

    @Builder.Default
    private List<String> errors = Collections.synchronizedList(new ArrayList<>());

    public void addError(final String error) {
        errors.add(error);
    }
}
