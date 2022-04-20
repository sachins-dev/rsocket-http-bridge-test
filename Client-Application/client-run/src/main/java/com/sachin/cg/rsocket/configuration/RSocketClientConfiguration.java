package com.sachin.cg.rsocket.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.protobuf.ProtobufDecoder;
import org.springframework.http.codec.protobuf.ProtobufEncoder;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.RSocketStrategies.Builder;
import org.springframework.util.ClassUtils;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

/**
 * @author Sachin.Shakya
 * @since 03-Apr-2022, Sunday 7:13 PM
 */
@Slf4j
@Configuration
public class RSocketClientConfiguration {

    @Bean
    public RSocketStrategies rSocketStrategies(ObjectProvider<RSocketStrategiesCustomizer> customizers) {
        Builder builder = RSocketStrategies.builder();
        if (ClassUtils.isPresent("org.springframework.web.util.pattern.PathPatternRouteMatcher", null)) {
            builder.routeMatcher(new PathPatternRouteMatcher());
        }

        builder.decoders(decoders -> decoders.add(new ProtobufDecoder()));
        builder.encoders(encoders -> encoders.add(new ProtobufEncoder()));

        customizers.orderedStream().forEach(customizer -> customizer.customize(builder));

        return builder.build();
    }

}