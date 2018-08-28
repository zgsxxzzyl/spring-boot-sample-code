package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     * @Cacheable(value = "user", key = "'user'.concat(#name)")
     * @param name
     * @return
     */
    @Override
    @Cacheable(value = "user", key = "'user'.concat(#name)")
    public User findUserByName(String name) {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

    @Override
    @CacheEvict(value = "user",allEntries = true)
    public void clear() {
        System.out.println("clear user");
        return;
    }


}
