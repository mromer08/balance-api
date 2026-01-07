package com.mromer.balance.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OpenApiConf {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Balance API")
                        .description("API documentation for BALANCE application")
                        .version("v1.0.0"));
    }
}
