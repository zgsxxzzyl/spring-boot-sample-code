package com.support;

import org.springframework.context.annotation.Bean;

//@Configuration
public class MultiSampleConfiguration {

    @Bean
    public PostProcessor postProcessor() {
        return new PostProcessor();
    }

}
