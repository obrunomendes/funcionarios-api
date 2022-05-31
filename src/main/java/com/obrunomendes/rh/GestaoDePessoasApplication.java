package com.obrunomendes.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestaoDePessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDePessoasApplication.class, args);
	}

}
