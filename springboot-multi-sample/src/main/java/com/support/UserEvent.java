package com.support;

import com.bean.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class UserEvent extends ApplicationEvent {

    private User user;

    public UserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
