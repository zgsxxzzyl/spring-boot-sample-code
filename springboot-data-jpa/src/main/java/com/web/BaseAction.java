package com.web;

import com.model.User;
import com.model.UserRowMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BaseAction {

    @Autowired
    @Qualifier("masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate;

    @Autowired
    @Qualifier("slave1JdbcTemplate")
    public JdbcTemplate slave1JdbcTemplate;

    @Autowired
    public UserService userService;

    @RequestMapping("/a")
    public List<User> master() {
        return masterJdbcTemplate.query("SELECT * FROM USER", new UserRowMapper());
    }

    @RequestMapping("/b")
    public List<User> slave1() {
        return slave1JdbcTemplate.query("SELECT * FROM USER", new UserRowMapper());
    }

}
