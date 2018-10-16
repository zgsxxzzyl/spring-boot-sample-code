package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/ex")
    @ResponseBody
    public String error() {
        int i = 5 / 0;
        return "ex";
    }

    @Autowired
    private CustomService customService;

    @GetMapping("/")
    public String index() {
        return customService.name();
    }
}
