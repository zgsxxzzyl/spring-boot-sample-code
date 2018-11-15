package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Value("${server.port}")
    private String port;


    /**
     * 根据ID查询用户信息
     * 2018年1月18日
     */
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Spring Cloud User service");
        user.setPassword("123123");
        user.setPort(port);
        return user;
    }
}
