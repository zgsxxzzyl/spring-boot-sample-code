package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BaseEController {

    @RequestMapping("demoe")
    public ModelAndView index() {
        return new ModelAndView("403");
    }
}
