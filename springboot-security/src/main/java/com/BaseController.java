package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base")
public class BaseController {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
