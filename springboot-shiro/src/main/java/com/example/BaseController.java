package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    @RequestMapping({"/", "/index"})
    public String index() {
//        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setAttribute("user", "mabh");
//        if (!subject.isAuthenticated()) {
//            UsernamePasswordToken token = new UsernamePasswordToken("user", "mabh");
//            token.setRememberMe(true);
//            subject.login(token);
//        }
        return "/login";
    }

    public boolean validate() {

        return false;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String username, String password) {
        if (username != null && password != null) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }
        return "/index";
    }
}
