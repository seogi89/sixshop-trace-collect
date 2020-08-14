package com.sixshop.collect.router;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.sixshop.collect.web.CollectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class CollectRouter {

    @Bean
    public RouterFunction<ServerResponse> route(CollectHandler handler) {
        return RouterFunctions.route(POST("/").and(accept(APPLICATION_JSON)), handler::trace)
            .andRoute(POST("/conversion").and(accept(APPLICATION_JSON)), handler::conversion)
            .andRoute(GET("/").and(accept(APPLICATION_JSON)), handler::ok);
    }

}
