package com.example.action;

import com.example.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    private BaseService baseService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping()
    public String index() {
        String result = baseService.test();
        return result;
    }

    @RequestMapping("user")
    public String getAll() {
        if (!stringRedisTemplate.hasKey("shabao")) {
            stringRedisTemplate.opsForValue().append("shabao", "我是傻宝");
        }else{
            stringRedisTemplate.delete("shabao");
        }
        String result = baseService.getAll();
        return result;
    }



}
