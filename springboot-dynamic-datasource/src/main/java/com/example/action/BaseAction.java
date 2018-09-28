package com.example.action;

import com.example.dao.UserDao;
import com.example.dao.support.TargetDataSource;
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
    @TargetDataSource("slave1")
    public List<User> other() {
        // TODO: 2018/9/28 实际过程中可以使用aop切换数据源，添加注解
//        DynamicDataSourceHolder.setDataSource("slave1");
        return userDao.queryAll();
    }
}
