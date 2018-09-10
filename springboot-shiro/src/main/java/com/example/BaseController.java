package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BaseController {

    @RequestMapping({"/","/index"})
    public String index(){
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("user","mabh");
        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("user","mabh");
            token.setRememberMe(true);
            subject.login(token);
        }
        return "/index";
    }

    public boolean validate(){

        return false;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "/login";
    }
}
