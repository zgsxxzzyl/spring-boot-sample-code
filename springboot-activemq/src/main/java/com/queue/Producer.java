package com.queue;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.jms.Queue;

//@Component
@EnableScheduling
public class Producer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue queue;

    /**
     * <a href="https://blog.csdn.net/jack_bob/article/details/78786740">关于@Scheduled的讲解</a>
     * <a href="http://cron.qqe2.com/">cron生成网站</a><br/>
     */
    @Scheduled(fixedDelay = 3000)//每3s执行1次
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(queue, "hi,activeMQ");
    }
}