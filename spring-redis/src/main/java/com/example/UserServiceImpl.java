package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//, key = "'user'.concat(#name)"
    @Override
    @Cacheable(value = "user")
    public User findUserByName(String name) {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }
}
