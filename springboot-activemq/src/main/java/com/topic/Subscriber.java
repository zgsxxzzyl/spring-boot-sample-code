package com.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    @JmsListener(destination = "test-topic", containerFactory = "jmsListenerContainerTopic")
    public void subscribe1(String text) {
        System.out.println("1===>> " + text);
    }


    @JmsListener(destination = "test-topic", containerFactory = "jmsListenerContainerTopic")
    public void subscribe2(String text) {
        System.out.println("2===>> " + text);
    }

    @JmsListener(destination = "test-topic", containerFactory = "jmsListenerContainerTopic")
    public void subscribe3(String text) {
        System.out.println("3===>> " + text);
    }
}
