package com.obrunomendes.rh.domain.converters;

import com.obrunomendes.rh.domain.TipoSexo;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Component
@Converter
public class TipoSexoConverter implements AttributeConverter<TipoSexo, String> {

    @Override
    public String convertToDatabaseColumn(TipoSexo value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return value.getDescricao();
    }

    @Override
    public TipoSexo convertToEntityAttribute(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return TipoSexo.toEnum(value);
    }
}
