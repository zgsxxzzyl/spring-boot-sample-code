package com.example;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 参照<a href="https://segmentfault.com/a/1190000011190467">https://segmentfault.com/a/1190000011190467</a>
 */
@SpringBootApplication
public class SprinbootActivemqApplication {
    public static void main(String[] args) {
        SpringApplication.run(SprinbootActivemqApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("test-queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("test-topic");
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        // 当消费者要接收topic的消息时，pubSubDomain必须设置为true。
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //当消费者要接收queue的消息时，pubSubDomain必须设置为false。
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(ActiveMQConnectionFactory connectionFactory) {
        return new JmsMessagingTemplate(connectionFactory);
    }
}
