package com.action;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserMapper;
import com.entity.Test;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("insert1")
//    @Transactional(readOnly = true)
    public int insert() {
        int count = userMapper.insert("admin1", 123);
        return count;
    }

    /**
     * 插入对象之后使用getId（）可以获取主键
     * 插入enum
     *
     * @return 主键
     */
    @RequestMapping("insert2")
    public Long insertPojo() {
        User user = new User();
        user.setName("admin");
        user.setAge(20);
        user.setSex(User.Sex.WOMAN);
        int count = userMapper.insertPojo(user);
        return user.getId();
    }

    /**
     * 插入对象之后使用getId（）可以获取主键
     *
     * @return 主键
     */
    @RequestMapping("insert3")
    public String insertProvider() {
        User user = new User();
        user.setAge(18);
        user.setName("AAA");
        Test t = new Test();
        t.setValue("123");
        int userCount = userMapper.insertProvider(user);
        int testCount = userMapper.insertProvider(t);
        return "userid-->" + user.getId() + "\r\n" + "testid-->" + t.getId();
    }

    @RequestMapping("insert4")
    public Long insertDynamicSQL() {
        // TODO: 2018/9/15
        User user = new User();
        user.setName("adminsql");
        user.setAge(20);
        user.setSex(User.Sex.WOMAN);
        int count = userMapper.insertDynamic(user);
        return user.getId();
    }

    @RequestMapping({"page", ""})
    public String page() {
        PageHelper.startPage(1, 6);
        List<User> users = userMapper.findByName("AAA");
        return JSONObject.toJSONString(users);
    }

    @RequestMapping("pageinfo")
    public String pageInfo() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.findByName("AAA");
        PageInfo info = new PageInfo(users);
        return JSONObject.toJSONString(info);
    }

    @RequestMapping("all")
    public List<User> all() {
        return userMapper.queryAll();
    }

    @RequestMapping("clear")
    public boolean clear() {
        boolean isClear = userMapper.clear();
        return isClear;
    }
}
