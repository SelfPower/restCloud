package com.szq.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLvel(){
        return Logger.Level.FULL;
    }
}
