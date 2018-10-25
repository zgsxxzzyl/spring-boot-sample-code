package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAction {

    @RequestMapping("de")
    public String demo() {
        return "redirect:detail.html";
    }

    @RequestMapping("de2")
    public String demo1() {
        return "demo";
    }
}
