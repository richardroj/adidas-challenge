package com.adidas.backend.prioritysaleservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "Members Service API",
    description = "Members Service API",
    version = "1.0",
    contact = @Contact(name = "Adidas", url = "https://adidas.com")))
public class MembersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersServiceApplication.class, args);
	}

}
