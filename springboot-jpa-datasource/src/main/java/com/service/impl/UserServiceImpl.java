package com.service.impl;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveUserWithRoll(User user) throws Exception {
        userRepository.save(user);
        throw new Exception();
    }

    @Override
    public void saveUser(User user) throws Exception {
        userRepository.save(user);
    }
}
