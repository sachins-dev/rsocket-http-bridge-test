package com.sachin.cg.rsocket.service;

import com.sachin.protobuf.payloads.request.SimpleRequest;
import com.sachin.protobuf.payloads.response.SimpleResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Sachin.Shakya
 * @since 03-Apr-2022, Sunday 7:47 PM
 */
@Slf4j
@Service
@AllArgsConstructor
public class RSocketTestService {

    private final WebClient webClient;
    private final DiscoveryClient discoveryClient;

    public Mono<SimpleResponse> requestResponse(Mono<SimpleRequest> requestMono) {
        List<ServiceInstance> instances = discoveryClient.getInstances("gateway");
        if (instances.size() < 1) {
            throw new IllegalArgumentException("No gateway instance found");
        }
        WebClient.RequestHeadersSpec<?> request = webClient.post()
                .uri(UriComponentsBuilder.fromUri(instances.get(0).getUri()).path("rr").build().toUri())
                .body(requestMono, SimpleRequest.class);
        return request.exchangeToMono(response -> {
            if (HttpStatus.OK.equals(response.statusCode())) {
                return response.bodyToMono(SimpleResponse.class);
            }
            return Mono.error(() -> new RuntimeException("Error occurred !!"));
        });
    }

}
