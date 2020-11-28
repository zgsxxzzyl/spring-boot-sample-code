package com.controller;

import com.dao.UserRepository;
import com.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public User add(@RequestParam(name = "username",required = true) String name) {
        User user = new User();
        user.setUsername(name);
        return userRepository.save(user);
    }

    @DeleteMapping("/del")
    public void del(Long id){
        userRepository.deleteById(id);
    }

    public void delete(String name) {
        userRepository.deleteUserByUsername(name);
    }

    public void update(Long id, String name) {
        userRepository.updateUserById(id, name);
    }
}
