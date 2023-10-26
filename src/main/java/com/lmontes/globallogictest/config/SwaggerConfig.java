package com.lmontes.globallogictest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Global Logic Test",
                version = "1.0.0",
                description = "Microservicio para registrar y loguear usuarios",
                contact = @Contact(name = "Leonardo Montes", email = "lmontes@gmail.com")
        )
)
public class SwaggerConfig {
}
