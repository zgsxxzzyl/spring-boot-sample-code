package com.example.action;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserAction implements BaseAction<User,Long> {

    @Autowired
    private UserDao userDao;

    @Override
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User query(@PathVariable Long id) {
        return userDao.queryById(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    @RequestMapping(method=RequestMethod.POST)
    public Long create(User user) {
        userDao.insertPojo(user);
        return user.getId();
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public boolean delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    @RequestMapping(value = "/",method=RequestMethod.PUT)
    public boolean update(User user) {
        return userDao.update(user);
    }
}
