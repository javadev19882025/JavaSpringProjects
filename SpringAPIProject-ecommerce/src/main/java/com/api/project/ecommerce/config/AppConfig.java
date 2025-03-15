package com.api.project.ecommerce.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for application-wide beans.
 */

@Configuration
public class AppConfig {

	/**
	 * Creates and configures a ModelMapper bean.
	 * 
	 * ModelMapper is used for object mapping, simplifying the conversion between
	 * DTOs (Data Transfer Objects) and entity classes.
	 *
	 * @return a new instance of ModelMapper
	 */

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
