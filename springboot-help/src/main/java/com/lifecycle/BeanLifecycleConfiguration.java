package com.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifecycleConfiguration {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle();
    }
}
