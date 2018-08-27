package com.example.action;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.UserMapper;
import com.example.entity.Test;
import com.example.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping()
    public String index() {
//        userMapper.insert("AAA", 20);
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
    @RequestMapping("page")
    public String page(){
        PageHelper.startPage(1,6);
        List<User> users = userMapper.findByName("AAA");
        return JSONObject.toJSONString(users);
    }
    @RequestMapping("pageinfo")
    public String pageInfo(){
        PageHelper.startPage(1,2);
        List<User> users = userMapper.findByName("AAA");
        PageInfo info = new PageInfo(users);
        return JSONObject.toJSONString(info);
    }
}
