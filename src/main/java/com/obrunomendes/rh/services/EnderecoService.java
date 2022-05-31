package com.obrunomendes.rh.services;

import com.obrunomendes.rh.client.ViaCepAPi;
import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.models.mappers.EnderecoMapper;
import com.obrunomendes.rh.models.request.EnderecoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final ViaCepAPi viaCepClient;
    private final EnderecoMapper mapper;

    public boolean deveBuscarEnderecoPorCep(EnderecoRequest endereco) {
        return Stream.of(endereco.getBairro(), endereco.getCidade(), endereco.getEstado())
                .allMatch(Objects::isNull);
    }

    public Endereco buscaEnderecoPorCep(String cep) {
        var formattedCep = cep.replaceAll("[^\\d ]", "");
        var response = viaCepClient.buscaCep(formattedCep);
        return mapper.viaCepToEndereco(response);
    }
}
