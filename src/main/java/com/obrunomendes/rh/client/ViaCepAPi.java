package com.obrunomendes.rh.client;

import com.obrunomendes.rh.models.response.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "https://viacep.com.br/ws")
public interface ViaCepAPi {

    @GetMapping("/{cep}/json")
    ViaCepResponse buscaCep(@PathVariable String cep);
}
