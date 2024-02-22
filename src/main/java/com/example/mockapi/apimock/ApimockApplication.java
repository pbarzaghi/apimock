package com.example.mockapi.apimock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApimockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimockApplication.class, args);
	}

}
