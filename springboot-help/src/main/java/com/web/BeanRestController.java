package com.web;

import com.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bean")
public class BeanRestController {
    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/test")
    public User test() {
        return (User) applicationContext.getBean("dynamic#user");
    }
}
