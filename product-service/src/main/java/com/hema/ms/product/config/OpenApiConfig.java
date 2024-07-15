package com.hema.ms.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productServiceOpenApiConfigBean() {
        return new OpenAPI()
                .info(new Info().title("Product Service Api Docs")
                        .description("product service description")
                        .version("1.0.0")
                        .license(new License().name("Ibrahim"))
                ).externalDocs(new ExternalDocumentation().description("external system for business docs")
                        .url("http://business-doc/product-service"));

    }
}
