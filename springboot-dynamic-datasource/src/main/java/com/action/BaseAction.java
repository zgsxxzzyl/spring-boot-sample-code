package com.action;

import com.dao.UserDao;
import com.dao.support.TargetDataSource;
import com.entity.User;
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
    @TargetDataSource("slave1")
    public List<User> other() {
//        DynamicDataSourceHolder.setDataSource("slave1");
        return userDao.queryAll();
    }

    @RequestMapping("slave1")
    @TargetDataSource("slave")
    public Long insertPojo() {
        User user = new User();
        user.setName("admin");
        user.setAge(20);
        user.setSex(User.Sex.WOMAN);
        int count = userDao.insertPojo(user);
        return user.getId();
    }

    @RequestMapping("master")
    @TargetDataSource("master")
    public Long insert() {
        User user = new User();
        user.setName("admin");
        user.setAge(20);
        user.setSex(User.Sex.WOMAN);
        int count = userDao.insertPojo(user);
        return user.getId();
    }
}
