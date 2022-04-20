package com.sachin.cg.http.service;

import com.sachin.cg.http.payloads.request.TestRequest;
import com.sachin.cg.http.payloads.response.TestResponse;
import com.sachin.cg.rsocket.controller.RSocketTestController;
import com.sachin.cg.transformer.TestReqResTransformer;
import com.sachin.protobuf.payloads.request.SimpleRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {

    private final RSocketTestController rSocketController;
    private final TestReqResTransformer transformer;

    public Mono<TestResponse> greet(Mono<TestRequest> testRequest) {
        Mono<SimpleRequest> simpleRequest = testRequest.map(transformer::getSimpleRequest);
        return rSocketController.requestResponse(simpleRequest)
                .map(transformer::getTestResponse);
    }

}