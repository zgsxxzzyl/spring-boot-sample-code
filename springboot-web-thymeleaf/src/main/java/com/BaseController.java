package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping(value = "/demo")
    public String demo(Model model) {
        String name = "jiangbei";
        model.addAttribute("name", name);
        return "/test";
    }
}
