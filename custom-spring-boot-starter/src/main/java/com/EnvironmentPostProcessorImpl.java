package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Properties;

@Order
@Configuration
public class EnvironmentPostProcessorImpl implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 获取配置
        String config = environment.getProperty("remote.config", "false");
        String url = environment.getProperty("remote.url");
        // 根据配置好的远端地址处理配置
        Properties properties = new Properties();
        properties.setProperty("region", "x");
        PropertySource propertySource = new PropertiesPropertySource("remoteProperties", properties);
        environment.getPropertySources().addLast(propertySource);
    }
}
