package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
