package com.service;

import com.model.User;

public abstract interface UserService {
    public abstract void saveUser(User user) throws Exception;
}
