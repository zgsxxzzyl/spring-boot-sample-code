package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller()
@RequestMapping("/ca")
public class ControllerAction {

    @RequestMapping("/de5")
    public ModelAndView de5() {
        return new ModelAndView("redirect:/static.html");
    }

    @RequestMapping("/de6")
    public ModelAndView de6() {
        return new ModelAndView("forward:/static.html");
    }

    @RequestMapping("/de10")
    public ModelAndView de10() {
        return new ModelAndView("template");
    }

    @RequestMapping("/de11")
    public ModelAndView de11() {
        return new ModelAndView("/template");
    }

    //访问不到
    @RequestMapping("/de12")
    public ModelAndView de12() {
        return new ModelAndView("static.html");
    }

    //访问不到
    @RequestMapping("/de7")
    public String de7() {
        return "/static.html";
    }

    @RequestMapping("/de8")
    public String de8() {
        return "/template";
    }

    //访问不到
    @RequestMapping("/de9")
    public String de9() {
        return "/static";
    }

    @RequestMapping("/de13")
    public ModelAndView de13(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
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
}
