package com.service;

import com.model.master.User;
import com.repository.master.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
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
