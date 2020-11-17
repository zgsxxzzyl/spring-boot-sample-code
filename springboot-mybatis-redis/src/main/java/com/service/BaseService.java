package com.service;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserMapper;
import com.entity.Test;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    private UserMapper userMapper;

    public String test() {
        User user = new User();
        user.setAge(18);
        user.setName("AAA");
        Test t = new Test();
        t.setValue("123");
        userMapper.insert(user);
        userMapper.insert(t);
        List<User> users = userMapper.findByName("AAA");
        return JSONObject.toJSONString(users);
    }

    //    @Cacheable(value="json_users")
    public String getAll() {
        List<User> users = userMapper.findByName("AAA");
        return JSONObject.toJSONString(users);
    }

}
