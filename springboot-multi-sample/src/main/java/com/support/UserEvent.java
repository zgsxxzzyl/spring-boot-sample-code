package com.support;

import com.bean.User;
import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    private User user;

    public UserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
