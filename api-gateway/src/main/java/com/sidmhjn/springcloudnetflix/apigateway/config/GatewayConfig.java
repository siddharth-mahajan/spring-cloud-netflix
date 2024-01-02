package com.sidmhjn.springcloudnetflix.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("service1_route", r -> r.path("/service1/**")
                .uri("lb://service1")) // Replace with appropriate service name or URL
            .route("service2_route", r -> r.path("/service2/**")
                .uri("lb://service2")) // Replace with appropriate service name or URL
            // Add more routes based on fetched configurations
            .build();
    }
}
