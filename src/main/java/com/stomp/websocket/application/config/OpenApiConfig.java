package com.stomp.websocket.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Electronic Commerce")
                        .description("Electronic Commerce Price")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Jose Leonardo Nieves")
                                .url("https://ingSistemasJL.com")
                                .email("ingSistemasJL@gmail.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }

}
