package com.example.config;

import com.example.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {

    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("springboot-shiro-sso");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(180000);
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCipherKey(Base64.getDecoder().decode("zyl"));
        cookieRememberMeManager.setCookie(simpleCookie());
        return cookieRememberMeManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(new UserRealm());
        defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager());
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, String> filterChainDefinitionMap = new HashMap<>();

//        filterChainDefinitionMap.put("/plugin/**","anon");
//        filterChainDefinitionMap.put("/css/**","anon");
//        filterChainDefinitionMap.put("/js/**","anon");
//
//        filterChainDefinitionMap.put("/**","authc");
//        filterChainDefinitionMap.put("/login/","anon");
//        filterChainDefinitionMap.put("/logout","logout");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/login.html");
//        shiroFilterFactoryBean.setSuccessUrl("/index.html");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        return shiroFilterFactoryBean;
    }


}
