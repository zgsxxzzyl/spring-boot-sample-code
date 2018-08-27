package com.example.action;

import com.example.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    private BaseService baseService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping()
    public String index() {
        String result = baseService.test();
        return result;
    }

    @RequestMapping("user")
    public String getAll() {
        String result = baseService.getAll();
        return result;
    }
}
