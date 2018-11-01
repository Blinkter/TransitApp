package com.example.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.transport.repository.CustomOrderRepositoryImpl;

@SpringBootApplication
public class TransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
	}
	
	@Bean
    public CustomOrderRepositoryImpl CustomOrderRepository() {
        return new CustomOrderRepositoryImpl ();
    }
}
