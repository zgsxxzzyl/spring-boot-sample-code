package com.controller;

import com.dao.UserRepository;
import com.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    public User add(String name) {
        User user = new User();
        user.setUsername(name);
        return userRepository.save(user);
    }

    public void delete(String name) {
        userRepository.deleteUserByUsername(name);
    }

    public void update(Long id, String name) {
        userRepository.updateUserById(id, name);
    }
}
