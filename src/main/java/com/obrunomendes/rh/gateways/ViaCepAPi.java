package com.obrunomendes.rh.gateways;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
public interface ViaCepAPi {

    void call();
}
