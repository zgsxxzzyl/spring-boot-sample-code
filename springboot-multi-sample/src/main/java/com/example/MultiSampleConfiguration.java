package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiSampleConfiguration {

    @Bean
    public PostProcessor postProcessor() {
        return new PostProcessor();
    }

}
