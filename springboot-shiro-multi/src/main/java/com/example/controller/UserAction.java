package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/user")
public class UserAction {
    private final static String REDIRECT = "redirect:";
    private final static String FORWARD = "forward:";
    private String defalutUrl = "/index.html";
    private String loginUrl = "/login.html";

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "remember", required = false) String remember,
                        @RequestParam(value = "takemeback", required = false) String takemeback) {
        try {
            if (!StringUtils.isEmpty(takemeback)) {
                defalutUrl = takemeback;
            }
            Subject subject = SecurityUtils.getSubject();
            if (subject.isRemembered() || subject.isAuthenticated()) {
                return REDIRECT + defalutUrl;
            } else {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                if (!StringUtils.isEmpty(remember) && Boolean.valueOf(remember)) {
                    token.setRememberMe(true);
                } else {
                    token.setRememberMe(false);
                }
                subject.login(token);
                Session session = subject.getSession();
                session.setTimeout(60000);       //设置会话超时时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(simpleDateFormat.format(session.getLastAccessTime()) + "-->>" + session.getHost());
            }
            return REDIRECT + defalutUrl;
        } catch (AuthenticationException e) {
            return REDIRECT + defalutUrl;
        }
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return REDIRECT + loginUrl;
    }

}
