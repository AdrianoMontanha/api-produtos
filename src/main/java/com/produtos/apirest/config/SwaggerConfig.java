package com.produtos.apirest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI().info(
                new Info().description("Definição de Apis para Validacões")
                        .version("1.0.0")
                        .title("Validações - OpenAPI 3.0 - Adriano Montanha")
                        
        );
    }

	}


