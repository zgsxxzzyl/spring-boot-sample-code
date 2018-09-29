package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BaseAction {

    @RequestMapping()
    public User a() {
        User user = new User();
        user.setId(123);
        user.setName("name");
        user.setCurTime(new Date());
        return user;
    }

}
