package com.sachin.http.rsocket.bridge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sachin.Shakya
 * @since 15-Apr-2022, Friday 7:59 PM
 */
@Slf4j
@SpringBootApplication
public class HttpRSocketBridgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpRSocketBridgeApplication.class, args);
    }

}