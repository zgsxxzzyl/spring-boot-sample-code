package com;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnBean(CustomMarker.Marker.class)
@EnableConfigurationProperties(CustomProperties.class)
public class CustomAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "custom.say", value = "enabled", havingValue = "true")
    CustomService exampleService() {
        return new CustomService();
    }
}
