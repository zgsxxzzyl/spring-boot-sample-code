package com.controller;

import com.bean.BeanDemo;
import com.bean.User;
import com.support.EventPublisherUtil;
import com.support.SpringUtil;
import com.support.UserEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MultiController {

    @Resource
    BeanDemo beanDemo;

    @Resource
    EventPublisherUtil eventPublisherUtil;

    @Value("custom.say")
    String say;

    @RequestMapping("/")
    public Object index() {
        BeanDemo demo = (BeanDemo) SpringUtil.getBean(BeanDemo.class);
        demo.setName("name");
        demo.setPassword("password");
        System.out.println(say);
        return demo;
    }

    @RequestMapping("/demo")
    public String demo() {
        return "中文";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        System.out.println("start");
        User user = new User();
        user.setName("123");
        user.setEmail("qwe");
        eventPublisherUtil.publishEvent(new UserEvent(this, user));
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("end");
    }
}
