package com.sixshop.collect.web;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.sixshop.collect.repository.TraceRepository;
import com.sixshop.collect.web.dto.TraceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CollectHandler {

    private final TraceRepository repository;

    public Mono<ServerResponse> ok(ServerRequest request) {
        return ServerResponse.ok().build();
    }

    public Mono<ServerResponse> collect(ServerRequest request) {
        return request.body(toMono(TraceRequest.class))
            .map(TraceRequest::toEntity)
            .doOnNext(repository::save)
            .then(ServerResponse.ok().build());
    }
}
