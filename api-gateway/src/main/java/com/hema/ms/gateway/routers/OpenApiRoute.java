package com.hema.ms.gateway.routers;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;

@Configuration
public class OpenApiRoute {

    @Bean
    public RouterFunction<ServerResponse> productServiceRouteDocs() {
        return GatewayRouterFunctions.route("product-service-docs")
                .route(RequestPredicates.GET("/aggregate/product-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8050"))
                .filter(setPath("/api-docs")) // to replace path to api-docs so we can access documentation api [json]
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRouteDocs() {
        return GatewayRouterFunctions.route("order-service-docs")
                .route(RequestPredicates.GET("/aggregate/order-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8051"))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRouteDocs() {
        return GatewayRouterFunctions.route("inventory-service-docs")
                .route(RequestPredicates.GET("/aggregate/inventory-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8052"))
                .filter(setPath("/api-docs"))
                .build();
    }
}
