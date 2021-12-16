package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableScheduling
@EnableWebSocketMessageBroker
public class SpringbootLogApplication {

    int info = 1;
    private Logger logger = LoggerFactory.getLogger(SpringbootLogApplication.class);
    @Resource
    private SimpMessagingTemplate messagingTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLogApplication.class, args);
    }

    @Scheduled(fixedRate = 1000)
    public void outputLogger() {
        logger.info("测试日志输出" + info++);
    }

    /**
     * 推送日志到/topic/pullLogger
     */
    @PostConstruct
    public void pushLogger() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> {
            while (true) {
                try {
                    if (messagingTemplate != null) {
                        LoggerMessage loggerMessage = new LoggerMessage();
                        loggerMessage.setLevel("info");
                        loggerMessage.setTimestamp(new Date().toString());
                        loggerMessage.setBody("1111");
                        messagingTemplate.convertAndSend("/topic/pullLogger", loggerMessage);
                    }
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

               /* try {
                    if (instance == null) {
                        System.out.println("log实例为空");
                        instance = LoggerQueue.getInstance();
                    }
                    LoggerMessage log = instance.poll();
                    if (log != null) {
                        if (messagingTemplate != null)
                            messagingTemplate.convertAndSend("/topic/pullLogger", log);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
            }
        };
        new Thread(runnable).start();
//        executorService.submit(runnable);
//        executorService.submit(runnable);
    }
}