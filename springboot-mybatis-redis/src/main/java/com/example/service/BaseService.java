package com.example.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.UserMapper;
import com.example.entity.Test;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    private UserMapper userMapper;


    public String test(){
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

//    @Cacheable(value = "user", key = "user-getAll")
//    @CachePut(value = "user", key = "user-getAll")
    public String getAll(){
        List<User> users = userMapper.findByName("AAA");
        return JSONObject.toJSONString(users);
    }

}
