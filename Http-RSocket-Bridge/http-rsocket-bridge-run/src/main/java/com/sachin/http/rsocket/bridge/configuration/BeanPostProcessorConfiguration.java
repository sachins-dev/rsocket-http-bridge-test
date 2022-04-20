package com.sachin.http.rsocket.bridge.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

/**
 * @author Sachin.Shakya
 * @since 15-Apr-2022, Friday 10:38 PM
 */
@Slf4j
@Component
public class BeanPostProcessorConfiguration implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RSocketRequester.Builder) {
            ((RSocketRequester.Builder) bean).dataMimeType(new MimeType("application", "x-protobuf"));
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

}
