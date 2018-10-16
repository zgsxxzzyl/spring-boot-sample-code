package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomService {
    @Autowired
    private CustomProperties customProperties;

    public String name() {
        return customProperties.getName();
    }
}
