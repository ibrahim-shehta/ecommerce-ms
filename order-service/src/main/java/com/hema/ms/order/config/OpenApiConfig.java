package com.hema.ms.order.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderServiceOpenApiConfigBean() {
        return new OpenAPI()
                .info(new Info().title("order Service Api Docs")
                        .description("order service description")
                        .version("1.0.0")
                        .license(new License().name("Ibrahim"))
                ).externalDocs(new ExternalDocumentation().description("external system for business docs")
                        .url("http://business-doc/order-service"));

    }
}
