package com.example.web.demo;

import com.example.web.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController()
@RequestMapping(path = "/login")
public class LoginController {
    @RequestMapping(value = "/v", method = RequestMethod.GET)
    public boolean Login(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        if (username.equals(password)) {
            request.getSession().setAttribute("user", new User(username, password));
            return true;
        }
        return false;
    }

    @RequestMapping(value = "in")
    public boolean index() {
        return false;
    }
}

