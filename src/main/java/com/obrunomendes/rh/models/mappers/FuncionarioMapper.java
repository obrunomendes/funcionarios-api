package com.obrunomendes.rh.models.mappers;

import com.obrunomendes.rh.domain.Funcionario;
import com.obrunomendes.rh.models.request.FuncionarioRequest;
import com.obrunomendes.rh.models.request.FuncionarioUpdateRequest;
import com.obrunomendes.rh.models.response.FuncionarioResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = EndereceMapper.class)
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    @BeanMapping(qualifiedByName = "setMatricula")
    Funcionario toFuncionario(FuncionarioRequest funcionarioRequest);

//    @Named("setMatricula")
//    @AfterMapping
//    default void fMatricula(@MappingTarget Funcionario funcionario) {
//        if (funcionario != null)
//            funcionario.setMatricula(UUID.randomUUID().toString());
//    }

    FuncionarioResponse toFuncionarioResponse(Funcionario funcionario);


    List<FuncionarioResponse> toListFuncionarioResponse(List<Funcionario> funcionario);

    Funcionario toFuncionario(FuncionarioUpdateRequest funcionarioRequest);

}

