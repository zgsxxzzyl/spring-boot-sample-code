package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/redirect")
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/index.html");
    }

    @GetMapping("/forward")
    public ModelAndView forward() {
        return new ModelAndView("forward:/index.html");
    }

    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    @GetMapping("/index1")
    public ModelAndView index1() {
        return new ModelAndView("index");
    }

    @GetMapping("/index2")
    public ModelAndView index2() {
        return new ModelAndView("/index");
    }

    @GetMapping("/index3")
    public ModelAndView index3(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println(path);
        System.out.println(basePath);
        System.out.println(requestURI);
        System.out.println(contextPath);
        return new ModelAndView("/template");
    }

    //访问不到
    @GetMapping("/static1")
    public String static1() {
        return "/static.html";
    }

    //访问不到
    @GetMapping("/static2")
    public String static2() {
        return "/static";
    }

    //访问不到
    @GetMapping("/static3")
    public ModelAndView static3() {
        return new ModelAndView("static.html");
    }

}
