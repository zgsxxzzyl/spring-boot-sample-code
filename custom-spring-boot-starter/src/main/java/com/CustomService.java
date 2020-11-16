package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomService {
    @Autowired
    private CustomProperties customProperties;

    public CustomService() {
        System.out.println("");
    }

    public String name() {
        return customProperties.getName();
    }
}
