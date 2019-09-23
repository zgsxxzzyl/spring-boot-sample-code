package com;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseController {

    @CrossOrigin
    @GetMapping("/login")
    public Object login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "登录成功");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        map.put("token", subject.getSession().getId());
        try {
            //Cookies创建
            token.setRememberMe(true);
            subject.login(token);
            Session session = subject.getSession();
            //这里设置session过期时间
            session.setTimeout(60 * 1000);
            session.setAttribute("currentuser", username);
        } catch (Exception e) {
            map.put("code", 204);
            map.put("msg", "登录失败");
            return map;
        }
        return map;
    }

    @GetMapping("/unlogin")
    public Object unlogin() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 204);
        map.put("msg", "未登录");
        return map;
    }

    @GetMapping("/test")
    public Object test() {
        Map<String, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        Object currentuser = subject.getSession().getAttribute("currentuser");
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("data", currentuser);
        return map;
    }

    @GetMapping("/logout")
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "退出成功");
        return map;
    }
}
