package com.web;

import com.alibaba.fastjson.JSON;
import com.bean.JsonBean;
import com.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/json")
public class JsonRestController {

    @GetMapping("/test")
    public JsonBean test() {
        JsonBean jsonBean = new JsonBean();
        jsonBean.setId(1);
        jsonBean.setCurTime(new Date());
        jsonBean.setName("mirror");
        return jsonBean;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @PostMapping("/poststr")
    public User poststr(@RequestBody String user) {
        System.out.println(user);
        return JSON.parseObject(user, User.class);
    }
}
