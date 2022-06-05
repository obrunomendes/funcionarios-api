package com.obrunomendes.rh.services;

import com.obrunomendes.rh.client.ViaCepAPi;
import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.domain.Estado;
import com.obrunomendes.rh.models.mappers.EnderecoMapper;
import com.obrunomendes.rh.models.request.EnderecoRequest;
import com.obrunomendes.rh.models.response.ViaCepResponse;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTests {

    @Mock
    EnderecoMapper mapper;

    @Mock
    ViaCepAPi client;

    @InjectMocks
    EnderecoService service;

    static ViaCepResponse viaCepResponse;

    static Endereco enderecoModel;

    @BeforeAll
    static void setUp() {
        enderecoModel = new Endereco("45650880", Estado.SP, "Algum bairro", "Algum lugar");
        viaCepResponse = ViaCepResponse.builder()
                .cep("45650880").bairro("Algum bairro").uf("SP")
                .logradouro("endereco x, rua YZ").localidade("Algum lugar")
                .build();
    }


    @Test
    public void deveBuscarEnderecoPorCep_success() {
        Mockito.when(client.buscaCep(Mockito.anyString())).thenReturn(viaCepResponse);
        Mockito.when(mapper.viaCepToEndereco(Mockito.any()))
                .thenReturn(enderecoModel);

        var endereco = Assertions.assertDoesNotThrow(() -> service.buscaEnderecoPorCep("45650880"));

        Assertions.assertEquals(endereco.getCep(), viaCepResponse.getCep());
    }

    @Test
    void deveBuscarEnderecoPorCep_fail() {
        Mockito.when(client.buscaCep(Mockito.anyString())).thenThrow(FeignException.FeignClientException.class);

        Assertions.assertThrows(FeignException.FeignClientException.class,
                () -> service.buscaEnderecoPorCep("45650880"));
    }

    @Test
    void deveBuscarEndereco_success() {
        EnderecoRequest request = new EnderecoRequest();
        request.setCep("45650-880");

        var isValid = Assertions.assertDoesNotThrow(() -> service.deveBuscarEnderecoPorCep(request));
        Assertions.assertTrue(isValid);
    }

    @Test
    void naoDeveBuscarEndereco_success() {
        EnderecoRequest request = new EnderecoRequest();
        request.setCep("45650-880");
        request.setBairro("bairro");

        var isInvalid = Assertions.assertDoesNotThrow(() -> service.deveBuscarEnderecoPorCep(request));
        Assertions.assertFalse(isInvalid);
    }


}
