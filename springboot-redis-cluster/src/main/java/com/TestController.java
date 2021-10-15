package com;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("test")
    public String test() {
        redisTemplate.opsForValue().set("demo", "test");
        return redisTemplate.opsForValue().get("demo");
    }
}
