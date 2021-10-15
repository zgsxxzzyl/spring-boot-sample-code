package com;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BaseController {
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping
    public String user(String name) {
        User user = userService.findUserByName("nihao");
        return JSONObject.toJSONString(user);
    }

    @RequestMapping("/clear")
    @ResponseBody
    public boolean clear() {
        userService.clear();
        return true;
    }
}
