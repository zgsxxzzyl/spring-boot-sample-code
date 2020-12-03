package com.action;

import com.alibaba.fastjson.JSON;
import com.entity.Contact;
import com.entity.ContactWithJavaUtilDate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/time")
    public String test() {
        Contact contact = new Contact();
        contact.setBirthday(LocalDate.now());
        contact.setLastUpdate(LocalDateTime.of(2015, 7, 12, 15, 15, 15, 10));
        return JSON.toJSONString(contact);
    }

    @RequestMapping("/time2")
    public String test2() {
        ContactWithJavaUtilDate contactWithJavaUtilDate = new ContactWithJavaUtilDate();
        contactWithJavaUtilDate.setBirthday(new Date());
        contactWithJavaUtilDate.setLastUpdate(new Date());
        return JSON.toJSONString(contactWithJavaUtilDate);
    }
}

