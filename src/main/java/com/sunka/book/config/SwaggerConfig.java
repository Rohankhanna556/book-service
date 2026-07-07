package com.sunka.book.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "User API",
        version = "1.0",
        description = "API documentation for User service"
    )
)
public class SwaggerConfig {
}
