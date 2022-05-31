package com.obrunomendes.rh.domain.converters;

import com.obrunomendes.rh.domain.Estado;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Component
@Converter
public class EstadoConverter implements AttributeConverter<Estado, String> {

    @Override
    public String convertToDatabaseColumn(Estado value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return value.name();
    }

    @Override
    public Estado convertToEntityAttribute(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return Estado.toEnum(value);
    }
}
