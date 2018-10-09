package com.example;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
public class SprinbootActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootActivemqApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }
}
