package com.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.Realm;

public class UserRealm implements Realm {

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthenticationToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"123".equals(password)) {
            throw new AuthenticationException("密码错误");
        }
        //TODO 数据库验证
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
