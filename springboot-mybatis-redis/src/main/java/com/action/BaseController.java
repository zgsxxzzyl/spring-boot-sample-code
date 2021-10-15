package com.action;

import com.service.BaseService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BaseController {
    @Resource
    private BaseService baseService;
    @Resource
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
        } else {
            stringRedisTemplate.delete("shabao");
        }
        String result = baseService.getAll();
        return result;
    }
}
