package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiController {

    @Autowired
    BeanDemo beanDemo;

    @Autowired
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
