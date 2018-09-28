package com.example.action;

import com.example.dao.UserDao;
import com.example.dao.support.DynamicDataSourceHolder;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SuppressWarnings("all")
public class BaseAction {

    @Autowired
    private UserDao userDao;

    @RequestMapping("a")
    public List<User> master() {
        return userDao.queryAll();
    }


    @RequestMapping("b")
    public List<User> other() {
        DynamicDataSourceHolder.setDataSource("slave1");
        return userDao.queryAll();
    }
}
