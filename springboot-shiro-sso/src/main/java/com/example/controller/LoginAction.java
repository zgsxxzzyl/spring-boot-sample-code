package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class LoginAction {

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam(value = "remember", required = false) String remember) {
//        System.out.println(username + "--" + password);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (!StringUtils.isEmpty(remember) && Boolean.valueOf(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }
        try {
            if (subject.isRemembered() || subject.isAuthenticated()) {
                return new ModelAndView("index.html");
            } else {
                subject.login(token);
            }
            return new ModelAndView("index.html");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ModelAndView("403");
        }
    }

    @RequestMapping("de1")
    public ModelAndView de() {
        return new ModelAndView("redirect:detail.html");
    }

}
