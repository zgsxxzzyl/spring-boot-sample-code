package com;

import org.springframework.stereotype.Service;

@Service("remoteService")
public class RemoteServiceImpl implements RemoteService {
    @Override
    public String offerName(String name) {
        return "Your name is : " + name;
    }
}
