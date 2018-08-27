package com.example.web.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/html")
public class HtmlController {
    @RequestMapping(path = "/demo")
    public String html(){
        return "/error.html";
    }
}
