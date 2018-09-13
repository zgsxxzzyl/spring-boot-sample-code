package com.example;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class CustomElseRealm implements Realm {
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        // TODO: 2018/9/8 这里可以决定过滤哪些token 
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        // TODO: 2018/9/8 实现具体的验证 如果身份认证验证成功，返回一个AuthenticationInfo实现；
        System.out.println("username:" + username + "---password:" + password);
//        if ("zhang".equals(username)) {
//            throw new AuthenticationException();
//        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}