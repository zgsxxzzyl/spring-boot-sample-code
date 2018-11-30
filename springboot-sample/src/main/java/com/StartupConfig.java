package com;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * ApplicationListener<ApplicationEvent>
 * <p>
 * 那么每当在一个ApplicationEvent发布到 ApplicationContext时，这个bean得到通知。其实这就是标准的Oberver设计模式。
 */
@Configuration
public class StartupConfig implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(event.toString());
    }
}
