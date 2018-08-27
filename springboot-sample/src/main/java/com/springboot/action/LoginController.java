package com.springboot.action;

import com.alibaba.fastjson.JSONObject;
import com.springboot.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/user")
public class LoginController {
    @RequestMapping(path = {"/login"}, params = {"username", "password"})
    public String login(HttpServletRequest request, String username, String password) {
        Object obj = request.getSession().getAttribute("user");
        if (obj != null && obj instanceof User) {
            if (((User) obj).getPassword().equals(password)) {
                return JSONObject.toJSONString((User) obj);
            }
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        request.getSession().setAttribute("user", user);
        return "SUCCESS";
    }

    @RequestMapping(path = "/v", params = {"username", "password"})
    public boolean validate(String username, String password) {
        return true;
    }


    @RequestMapping(path = "/layout")
    public boolean layout() {
        return true;
    }
}
