package com.thewa.cnkart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.annotations.OpenAPI31;

@OpenAPI31
@SpringBootApplication
public class CnkartApplication {
	public static void main(String[] args) {
		SpringApplication.run(CnkartApplication.class, args);
	}
}