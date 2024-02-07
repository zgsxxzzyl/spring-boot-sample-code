package com.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean
    public RateLimiter rateLimiter() {
        return RateLimiter.create(6.0);
    }
}
