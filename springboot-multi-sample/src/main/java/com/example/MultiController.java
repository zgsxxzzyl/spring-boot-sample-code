package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiController {

    @Autowired
    BeanDemo beanDemo;

    @RequestMapping("/")
    public Object index() {
        BeanDemo demo = (BeanDemo) SpringUtil.getBean(BeanDemo.class);
        demo.setName("name");
        demo.setPassword("password");
        return demo;
    }
}
