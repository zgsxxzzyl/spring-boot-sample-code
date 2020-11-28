package com.scenes.a;

import org.springframework.stereotype.Service;

@Service("AService")
public class AServiceImpl implements AService {

    @Override
    public String whoami(String name) {
        return "hi , your name is : " + name;
    }
}
