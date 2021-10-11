package com;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomService {
    @Resource
    private CustomProperties customProperties;

    public CustomService() {
        System.out.println("");
    }

    public String name() {
        return customProperties.getName();
    }
}
