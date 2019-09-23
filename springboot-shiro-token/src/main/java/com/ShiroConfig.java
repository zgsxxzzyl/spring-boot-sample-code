package com;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Autowired
    private MyRealm myRealm;

    @Bean("shirFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiro = new ShiroFilterFactoryBean();
        shiro.setLoginUrl("/unlogin");  //没有登陆的json返回
        shiro.setUnauthorizedUrl("/no");    //没有权限的json返回
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/map", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        //注意,如果roles[admin,guest]是用户需要同时包含两者角色才可以访问,是且的关系;
        //如果想改为或的关系,请继承AuthorizationFilter并加入过滤连,perm资源也是一样,需要继承PermissionsAuthorizationFilter加入过滤链;
        filterChainDefinitionMap.put("/test", "authc,roles[admin]");
        filterChainDefinitionMap.put("/**", "authc");
        shiro.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiro.setSecurityManager(securityManager);
        return shiro;
    }


    @Bean("securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager def = new DefaultWebSecurityManager();
        def.setRealm(myRealm);
        // 自定义session管理 使用redis
        SessionConfig sessionConfig = new SessionConfig();
        SessionDAOConfig sessionDAOConfig = new SessionDAOConfig();
        sessionConfig.setSessionDAO(sessionDAOConfig);
        //sessionConfig.setSessionDAO(new SessionDaoConfig());
        def.setSessionManager(sessionConfig);
        // 自定义缓存实现 使用redis
        //def.setCacheManager();
        return def;
    }
}