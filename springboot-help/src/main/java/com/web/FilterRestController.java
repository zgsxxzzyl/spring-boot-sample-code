package com.web;

import com.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/filter")
@RestController
public class FilterRestController {
    @GetMapping("/test")
    public String test() {
        return "被过滤器过滤的请求";
    }

    @GetMapping("/test1")
    public User test1() {
        User user = new User();
        user.setName("中文");
        return user;
    }
}
