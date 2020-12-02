package com;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     * @param name
     * @return
     * @Cacheable(value = "user", key = "'user'.concat(#name)")
     */
    @Override
    @Cacheable(value = "user", key = "'user'.concat(#name)")
    public User findUserByName(String name) {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

    @Override
    @CacheEvict(value = "user", allEntries = true)
    public void clear() {
        System.out.println("clear user");
        return;
    }
}
