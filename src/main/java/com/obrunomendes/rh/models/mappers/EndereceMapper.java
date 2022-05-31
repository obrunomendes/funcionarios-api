package com.obrunomendes.rh.models.mappers;

import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.models.request.EnderecoRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EndereceMapper {
    EndereceMapper INSTANCE = Mappers.getMapper(EndereceMapper.class);


    Endereco toEndereco(EnderecoRequest enderecoRequest);
    //Endereco toEndereco(EnderecoRequest enderecoRequest);
}
