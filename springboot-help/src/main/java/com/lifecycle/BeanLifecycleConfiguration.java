package com.lifecycle;

import org.springframework.context.annotation.Bean;

//@Configuration
public class BeanLifecycleConfiguration {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle();
    }
}
