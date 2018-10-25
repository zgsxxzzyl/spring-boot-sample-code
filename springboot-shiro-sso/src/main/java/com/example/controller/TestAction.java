package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAction {

    @RequestMapping("/de")   //pass
    public String demo() {
        return "redirect:/detail.html";
    }

    @RequestMapping("de4")      //pass
    public String demo4() {
        return "forward:/detail.html";
    }

    @RequestMapping("de5")
    public String demo5() {
        return "forward:/detail";
    }

    @RequestMapping("de6")      //pass
    public String demo6() {
        return "forward:/de";
    }

    @RequestMapping("de2")      //pass
    public String demo1() {
        return "demo";
    }

    @RequestMapping("de3")
    public String demo3() {
        return "detail";
    }
}
