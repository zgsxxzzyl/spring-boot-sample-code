package com;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class EventPublisherUtil implements ApplicationContextAware, ApplicationEventPublisherAware {
    private static ApplicationContext context;
    private static volatile EventPublisherUtil conf;
    private ApplicationEventPublisher publisher;

    private static EventPublisherUtil getInstance() {
        if (conf == null) {
            synchronized (EventPublisherUtil.class) {
                if (conf == null) {
                    conf = context.getBean(EventPublisherUtil.class);
                }
            }
        }
        return conf;
    }

    public static void publicPublishEvent(Object eventObject) {
        EventPublisherUtil.getInstance().publishEvent(eventObject);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publishEvent(Object eventObject) {
        publisher.publishEvent(eventObject);
    }

}
