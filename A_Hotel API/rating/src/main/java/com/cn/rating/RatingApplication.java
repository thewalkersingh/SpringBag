package com.cn.rating;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.annotations.OpenAPI31;

@OpenAPI31
@SpringBootApplication
public class RatingApplication {
	public static void main(String[] args) {SpringApplication.run(RatingApplication.class, args);}
}