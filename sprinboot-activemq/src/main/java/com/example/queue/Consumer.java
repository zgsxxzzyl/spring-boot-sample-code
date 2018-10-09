package com.example.queue;

import org.springframework.jms.annotation.JmsListener;

//@Component
public class Consumer {

    @JmsListener(destination = "test-queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String text) {
        System.out.println(text);
    }

}