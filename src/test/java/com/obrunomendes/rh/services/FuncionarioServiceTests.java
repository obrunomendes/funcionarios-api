package com.obrunomendes.rh.services;

import com.obrunomendes.rh.domain.Endereco;
import com.obrunomendes.rh.domain.Estado;
import com.obrunomendes.rh.domain.Funcionario;
import com.obrunomendes.rh.domain.TipoSexo;
import com.obrunomendes.rh.exceptions.EnderecoNotFoundException;
import com.obrunomendes.rh.exceptions.FuncionarioNotFoundException;
import com.obrunomendes.rh.models.mappers.FuncionarioMapper;
import com.obrunomendes.rh.models.request.EnderecoRequest;
import com.obrunomendes.rh.models.request.FuncionarioRequest;
import com.obrunomendes.rh.models.response.EnderecoResponse;
import com.obrunomendes.rh.models.response.FuncionarioResponse;
import com.obrunomendes.rh.repositories.FuncionarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTests {

    @Mock
    private FuncionarioRepository funcionarioRepository;
    @Mock
    FuncionarioMapper mapper;
    @InjectMocks
    FuncionarioService service;

    @Mock
    EnderecoService enderecoService;

    Endereco enderecoModel = enderecoModel =
            new Endereco("45650880", Estado.SP, "Algum bairro", "Algum lugar");
    Funcionario funcionarioModel =
            new Funcionario(1, "", "UsuarioTeste",
                    LocalDate.parse("1990-12-13"), TipoSexo.FEMININO, enderecoModel);

    FuncionarioRequest funcionarioRequest;
    EnderecoRequest enderecoRequest;

    EnderecoResponse enderecoResponse;
    FuncionarioResponse funcionarioResponse;


    @BeforeEach
    void setUp() {
        enderecoRequest = EnderecoRequest.builder()
                .cep("45650880")
                .estado(Estado.SP.name())
                .bairro("Algum bairro").cidade("Algum lugar")
                .build();

        funcionarioRequest = funcionarioRequest.builder()
                .dataNascimento(LocalDate.parse("1990-12-13"))
                .nome("Usuario Teste")
                .sexo(TipoSexo.FEMININO).endereco(enderecoRequest)
                .build();

        enderecoResponse = EnderecoResponse.builder()
                .cep("45650880")
                .estado(Estado.SP.name())
                .bairro("Algum bairro").cidade("Algum lugar")
                .build();

        funcionarioResponse = FuncionarioResponse.builder()
                .dataNascimento(LocalDate.parse("1990-12-13"))
                .nome("Usuario Teste")
                .sexo(TipoSexo.FEMININO).endereco(enderecoResponse)
                .build();
    }

    @Test
    void deveCadastrarFuncionarioApenasCepInformado_sucesso() {
        when(enderecoService.deveBuscarEnderecoPorCep(any())).thenReturn(true);
        when(enderecoService.buscaEnderecoPorCep(anyString())).thenReturn(enderecoModel);

        when(funcionarioRepository.save(any())).thenReturn(funcionarioModel);
        when(mapper.toFuncionario(any(FuncionarioRequest.class))).
                thenReturn(funcionarioModel);
        when(mapper.toFuncionarioResponse(any())).thenReturn(funcionarioResponse);

        var response = Assertions.assertDoesNotThrow(() -> service.criaOuAtualizaFuncionario(funcionarioRequest));

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getDataNascimento(), funcionarioResponse.getDataNascimento());
    }

    @Test
    void deveCadastrarFuncionario_sucesso() {
        when(enderecoService.deveBuscarEnderecoPorCep(any())).thenReturn(false);
        when(funcionarioRepository.save(any())).thenReturn(funcionarioModel);
        when(mapper.toFuncionario(any(FuncionarioRequest.class))).
                thenReturn(funcionarioModel);
        when(mapper.toFuncionarioResponse(any())).thenReturn(funcionarioResponse);

        var response = Assertions.assertDoesNotThrow(() -> service.criaOuAtualizaFuncionario(funcionarioRequest));

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getDataNascimento(), funcionarioResponse.getDataNascimento());
    }

    @Test()
    void deveCadastrarFuncionario_fail_NotFoundException() {
        when(mapper.toFuncionario(any(FuncionarioRequest.class))).
                thenReturn(funcionarioModel);

        when(enderecoService.deveBuscarEnderecoPorCep(any())).thenReturn(true);
        doThrow(EnderecoNotFoundException.class).when(enderecoService).buscaEnderecoPorCep(anyString());

        Assertions.assertThrows(EnderecoNotFoundException.class,
                () -> service.criaOuAtualizaFuncionario(funcionarioRequest));
    }


    @Test
    void deveBuscarFuncionarioPorId_success() {
        when(funcionarioRepository.findById(anyInt())).thenReturn(Optional.of(funcionarioModel));
        when(mapper.toFuncionarioResponse(funcionarioModel)).thenReturn(funcionarioResponse);

        var response = Assertions.assertDoesNotThrow(() -> service.buscaFuncionarioPorId(1));

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getDataNascimento(), funcionarioResponse.getDataNascimento());
    }

    @Test
    void deveBuscarFuncionarioPorId_fail_NotFoundException() {
        Mockito.doThrow(FuncionarioNotFoundException.class)
                .when(funcionarioRepository).findById(anyInt());

        Assertions.assertThrows(FuncionarioNotFoundException.class, () -> service.buscaFuncionarioPorId(1));
    }
}
