package com.example.web.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "com.config")
public class ConfigBean {
    private String name;
    private String value;

    @Override
    public String toString() {
        return "ConfigBean{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
