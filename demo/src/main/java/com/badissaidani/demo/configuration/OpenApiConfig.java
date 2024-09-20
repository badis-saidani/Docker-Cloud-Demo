package com.badissaidani.demo.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Badis Saidani",
                        email = "saidanii.badis@gmail.com",
                        url = "https://github.com/badis-saidani"
                ),
                description = "OpenApi documentation for the Welcome Demo App",
                title = "OpenApi Spec for Welcome App",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local Env",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Prod Env",
                        url = "http://prod:8080"
                )
        }
)
public class OpenApiConfig {
}
