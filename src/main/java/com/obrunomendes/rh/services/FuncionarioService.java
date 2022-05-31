package com.obrunomendes.rh.services;

import com.obrunomendes.rh.domain.Funcionario;
import com.obrunomendes.rh.exceptions.FuncionarioNotFoundException;
import com.obrunomendes.rh.models.mappers.FuncionarioMapper;
import com.obrunomendes.rh.models.request.FuncionarioRequest;
import com.obrunomendes.rh.models.request.FuncionarioUpdateRequest;
import com.obrunomendes.rh.models.response.FuncionarioResponse;
import com.obrunomendes.rh.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoService enderecoService;
    private final FuncionarioMapper mapper;


    public FuncionarioResponse criaOuAtualizaFuncionario(FuncionarioRequest request) {
        var funcionario = mapper.toFuncionario(request);
        funcionario.setMatricula(UUID.randomUUID().toString());

        var deveBuscarPorCep = enderecoService.deveBuscarEnderecoPorCep(request.getEndereco());
        if (deveBuscarPorCep) {
            var endereco = enderecoService.buscaEnderecoPorCep(request.getEndereco().getCep());
            funcionario.setEndereco(endereco);
        }

        funcionario = funcionarioRepository.save(funcionario);

        return mapper.toFuncionarioResponse(funcionario);
    }

    public FuncionarioResponse buscaFuncionarioPorId(Integer id) {
        var response = buscarFuncionarioPorId(id);

        return mapper.toFuncionarioResponse(response);
    }

    public Page<FuncionarioResponse> listarFuncionarios(Pageable pageable) {
        pageable = PageRequest.of(0, 5);
        var response = funcionarioRepository.findAll(pageable);
        var pageResponse = mapper.toListFuncionarioResponse(response.getContent());
        return new PageImpl<>(pageResponse, pageable, response.getTotalPages());
    }

    public Page<FuncionarioResponse> buscaFuncionariosPorCep(String cep) {
        var pageable = PageRequest.of(0, 5);
        var response = funcionarioRepository.findAllByEndereco_Cep(cep, pageable);
        var pageResponse = mapper.toListFuncionarioResponse(response.getContent());

        return new PageImpl<>(pageResponse, pageable, response.getTotalPages());
    }

    public FuncionarioResponse atualizarFuncionario(FuncionarioRequest request) {
        var funcionario = mapper.toFuncionario(request);
        funcionario = funcionarioRepository.save(funcionario);

        var response = mapper.toFuncionarioResponse(funcionario);
        return response;
    }

    public void atualizacaoParcial(FuncionarioUpdateRequest request) {
        var funcionario = buscarFuncionarioPorId(request.getId());

        //atualiza apenas os campos nao nulos
        var func = mapper.toUpdateFuncionario(request, funcionario);
        var endereco = enderecoService.buscaEnderecoPorCep(func.getEndereco().getCep());
        func.setEndereco(endereco);

        funcionarioRepository.save(funcionario);
    }

    public void removeFuncionarioPorId(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    private Funcionario buscarFuncionarioPorId(Integer id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionario nao encontrado"));
    }
}