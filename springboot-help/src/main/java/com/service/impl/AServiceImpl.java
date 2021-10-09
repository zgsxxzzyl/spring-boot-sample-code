package com.service.impl;

import com.service.AService;
import org.springframework.stereotype.Service;

@Service("aService")
public class AServiceImpl implements AService {

    @Override
    public String whoami(String name) {
        return "hi , your name is : " + name;
    }
}
