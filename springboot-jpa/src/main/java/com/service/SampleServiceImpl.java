package com.service;

import com.model.master.User;
import com.repository.master.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SampleServiceImpl implements SampleService {

    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveDemo() {
        User user = new User();
        user.setAge(18);
        user.setName("zhang三");
        userRepository.save(user);
//        int i = 1 / 0;
    }
}
