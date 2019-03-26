package com;

import lombok.Data;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserEventListener implements ApplicationListener<UserEvent> {
    @Async
    @Override
    public void onApplicationEvent(UserEvent event) {
        User user = event.getUser();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
