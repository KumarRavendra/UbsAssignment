package com.ubs.assignment;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.ubs.assignment.controllers",
		"com.ubs.assignment.servicesImpl","com.ubs.assignment.model","com.ubs.assignment.errorhandler"})
@EnableSwagger2
public class UbsAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsAssignmentApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/primes/*"))
				.apis(RequestHandlerSelectors.basePackage("com.ubs.assignment.controllers"))
				.build()
				.apiInfo(apiDetails());
				
	}
	
	public ApiInfo apiDetails() {
		
		return new ApiInfo(
				"Prime Number Generator API",
				"This is an API which helps you to generate the List of All Prime Numbers less than or equal to a provided Number",
				"1.0",
				"Free To Use",
				new springfox.documentation.service.Contact("Ravendra Kumar",null,"ravendramailbox@gmail.com"),
				"API License : Free To Use",
				"ravendramailbox@gmail.com",
				Collections.emptyList()
				);
	}
	

}
