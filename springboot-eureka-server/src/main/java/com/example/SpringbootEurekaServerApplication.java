package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringbootEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEurekaServerApplication.class, args);
    }
}
