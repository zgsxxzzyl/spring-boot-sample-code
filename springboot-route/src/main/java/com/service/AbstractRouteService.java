package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRouteService {
    @Autowired
    protected RestTemplate restTemplate;
    @Value("${gateway.url}")
    protected String gatewayUrl;

}
