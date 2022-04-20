package com.sachin.cg.rsocket.controller;

import com.sachin.cg.rsocket.service.RSocketTestService;
import com.sachin.protobuf.payloads.request.SimpleRequest;
import com.sachin.protobuf.payloads.response.SimpleResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Sachin.Shakya
 * @since 03-Apr-2022, Sunday 7:46 PM
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "rs")
public class RSocketTestController {

    private final RSocketTestService rSocketTestService;

    @PostMapping(value = "/request-response")
    public Mono<SimpleResponse> requestResponse(@RequestBody Mono<SimpleRequest> simpleRequest) {
        return rSocketTestService.requestResponse(simpleRequest);
    }

}