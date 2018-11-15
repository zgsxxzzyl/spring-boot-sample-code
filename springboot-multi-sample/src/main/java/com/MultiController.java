package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiController {

    @Autowired
    BeanDemo beanDemo;

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
}
