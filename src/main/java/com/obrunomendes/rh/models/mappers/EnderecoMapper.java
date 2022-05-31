package com.obrunomendes.rh.models.mappers;

import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.models.request.EnderecoRequest;
import com.obrunomendes.rh.models.response.EnderecoResponse;
import com.obrunomendes.rh.models.response.ViaCepResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);


    Endereco toEndereco(EnderecoRequest enderecoRequest);

    Endereco toEndereco(EnderecoResponse enderecoResponse);

    @Mappings({
            @Mapping(source = "uf", target = "estado"),
            @Mapping(source = "localidade", target = "cidade")
    })
    Endereco viaCepToEndereco(ViaCepResponse viaCepResponse);

}
