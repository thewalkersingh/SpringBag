package com.thewa.hotel;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPI31
public class HotelApplication {
	public static void main(String[] args) {SpringApplication.run(HotelApplication.class, args);}
}