package com.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rca")
public class RestControllerAction {
    @GetMapping("/regex/{id:\\d+}")
    public Long getUserById(@PathVariable Long id) {
        return id;
    }

    @RequestMapping("/de1")
    public ModelAndView de1() {
        return new ModelAndView("redirect:/static.html");
    }

    @RequestMapping("/de2")
    public ModelAndView de2() {
        return new ModelAndView("forward:/static.html");
    }

    @RequestMapping("/de3")
    public ModelAndView de3() {
        return new ModelAndView("redirect:/template");
    }

    @RequestMapping("/de4")
    public String de4() {
        return "de4";
    }
}
