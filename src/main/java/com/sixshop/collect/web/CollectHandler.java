package com.sixshop.collect.web;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;

import com.sixshop.collect.repository.ConversionRepository;
import com.sixshop.collect.repository.TraceRepository;
import com.sixshop.collect.web.dto.ConversionRequest;
import com.sixshop.collect.web.dto.TraceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CollectHandler {

    private final TraceRepository traceRepository;
    private final ConversionRepository conversionRepository;

    public Mono<ServerResponse> ok(ServerRequest request) {
        return ServerResponse.ok().build();
    }

    public Mono<ServerResponse> trace(ServerRequest request) {
        return request.body(toMono(TraceRequest.class))
            .map(TraceRequest::toEntity)
            .doOnNext(traceRepository::save)
            .then(ServerResponse.ok().build());
    }

    public Mono<ServerResponse> conversion(ServerRequest request) {
        return request.body(toMono(ConversionRequest.class))
            .map(ConversionRequest::toEntity)
            .doOnNext(conversionRepository::save)
            .then(ServerResponse.ok().build());
    }
}
