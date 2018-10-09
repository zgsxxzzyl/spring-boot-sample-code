package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;


    @Scheduled(fixedDelay = 3000)//每3s执行1次
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
    }


}