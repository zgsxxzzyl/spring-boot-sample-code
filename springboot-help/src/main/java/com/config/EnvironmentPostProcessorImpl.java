package com.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Order
@Component
public class EnvironmentPostProcessorImpl implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        if (environment instanceof ConfigurableEnvironment) {
            // 获取配置
            String config = environment.getProperty("remote.config", "false");
            String url = environment.getProperty("remote.url");
            // 根据配置好的远端地址处理配置
            Properties properties = new Properties();
            properties.setProperty("region", "x");
            PropertySource propertySource = new PropertiesPropertySource("remoteProperties", properties);
            ((ConfigurableEnvironment) environment).getPropertySources().addLast(propertySource);
        }
    }

}
