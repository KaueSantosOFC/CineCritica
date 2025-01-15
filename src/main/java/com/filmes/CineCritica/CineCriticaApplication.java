package com.filmes.CineCritica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CineCriticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineCriticaApplication.class, args);
	}

}
