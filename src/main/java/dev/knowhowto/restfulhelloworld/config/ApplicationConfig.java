package dev.knowhowto.restfulhelloworld.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Hello World App", version = "23.0.0"))
class ApplicationConfig {
}
