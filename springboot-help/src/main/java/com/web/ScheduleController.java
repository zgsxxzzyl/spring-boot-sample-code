package com.web;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    private ScheduledFuture future;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @RequestMapping("/start")
    public String startCron() {
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/5 * * * * *"));
        System.out.println("DynamicTask.startCron");
        return "DynamicTask.startCron";
    }

    @RequestMapping("/stop")
    public String stopCron() {
        if (future != null) {
            future.cancel(true);
        }
        System.out.println("DynamicTask.stopCron");
        return "DynamicTask.stopCron";
    }

    @RequestMapping("/edit")
    public String editCron() {
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger("*/1 * * * * *").nextExecutionTime(triggerContext);
            }
        });
        System.out.println("DynamicTask.editCron");
        return "DynamicTask.editCron";
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("DynamicTask.MyRunnable.run()，" + new Date());
        }
    }
}
