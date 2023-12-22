package com.sidmhjn.springcloudnetflix.discoveryserver.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI baseOpenAPI() {
		// TODO Auto-generated method stub
		return new OpenAPI().info(new Info().title("Discovery Server").version("1.0.1"));
	}
}
