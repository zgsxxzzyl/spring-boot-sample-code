package com.example.web.demo.support;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleTest {

    @Scheduled(cron = "0/1 * * * * ?") // 每秒执行一次
    public void scheduler() {

        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");

    }
}
