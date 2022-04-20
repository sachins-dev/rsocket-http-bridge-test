package com.sachin.http.rsocket.bridge.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.protobuf.ProtobufDecoder;
import org.springframework.http.codec.protobuf.ProtobufEncoder;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.ClassUtils;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

/**
 * @author Sachin.Shakya
 * @since 15-Apr-2022, Friday 8:04 PM
 */
@Slf4j
@Configuration
public class HttpRSocketBridgeConfiguration {

    @Bean
    public RSocketStrategies rSocketStrategies(ObjectProvider<RSocketStrategiesCustomizer> customizers) {
        RSocketStrategies.Builder builder = RSocketStrategies.builder();
        if (ClassUtils.isPresent("org.springframework.web.util.pattern.PathPatternRouteMatcher", null)) {
            builder.routeMatcher(new PathPatternRouteMatcher());
        }

        builder.decoders(decoders -> decoders.add(new ProtobufDecoder()));
        builder.encoders(encoders -> encoders.add(new ProtobufEncoder()));

        customizers.orderedStream().forEach(customizer -> customizer.customize(builder));

        return builder.build();
    }


}