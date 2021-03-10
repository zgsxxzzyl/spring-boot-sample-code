package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    //    @Autowired
//    private User user;
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/list")
    public void demo() {
//        System.out.println(user.toString());
        System.out.println(applicationContext.getBean("user"));
    }
}
