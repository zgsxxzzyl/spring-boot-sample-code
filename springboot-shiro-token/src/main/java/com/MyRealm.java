package com;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "myRealm";
    }

    //权限认证,通过名字读取角色死数据
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(username);
        SimpleAuthorizationInfo sim = new SimpleAuthorizationInfo();
        if (username.equals(Constant.USERNAME)) {
            sim.addRole(Constant.ROLE1);
        } else {
            sim.addRole(Constant.ROLE2);
        }
        return sim;
    }

    //身份验证,这里密码写死
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        if (username == null) {
            return null;
        }
        SimpleAuthenticationInfo sim = new SimpleAuthenticationInfo(username, Constant.PASSWORD, this.getName());
        return sim;
    }
}