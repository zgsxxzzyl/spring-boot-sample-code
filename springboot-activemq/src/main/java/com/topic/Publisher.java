package com.topic;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;

@Component
@EnableScheduling
public class Publisher {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Topic topic;

    @Scheduled(fixedDelay = 3000)//每3s执行1次
    public void send() {
        jmsMessagingTemplate.convertAndSend(topic, "hi,activeMQ-topic");
    }
}
