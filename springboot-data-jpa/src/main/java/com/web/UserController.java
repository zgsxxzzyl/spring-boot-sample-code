package com.web;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/save"})
    public Object user() {
        User user = new User();
        user.setAge(123);
        user.setName("gl");
        user.setSex(User.Sex.WOMAN);
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
