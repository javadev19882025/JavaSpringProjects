package com.api.project.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class for the Spring Boot application.
 * The @SpringBootApplication annotation marks it as a Spring Boot application.
 * 
 * The main method initializes and runs the application using
 * SpringApplication.run().
 */

@SpringBootApplication
public class SpringApiProjectEcommerceApplication {

	/**
	 * The entry point of the Spring Boot application.
	 * 
	 * @param args Command-line arguments passed during application startup.
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringApiProjectEcommerceApplication.class, args);
	}

}
