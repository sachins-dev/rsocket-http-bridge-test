package com.sachin.cg.http.controller;

import com.sachin.cg.http.payloads.request.TestRequest;
import com.sachin.cg.http.payloads.response.TestResponse;
import com.sachin.cg.http.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Sachin.Shakya
 * @since 03-Apr-2022, Sunday 10:22 PM
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class TestController {

    private final TestService testService;

    @PostMapping(value = "/greet")
    public Mono<TestResponse> greet(@RequestBody Mono<TestRequest> testRequest) {
        return testService.greet(testRequest);
    }

}
