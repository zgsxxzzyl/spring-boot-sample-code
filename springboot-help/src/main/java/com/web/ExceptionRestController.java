package com.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证统一异常处理
 */
@RestController
@RequestMapping("/exception")
public class ExceptionRestController {

    @GetMapping(value = "/error")
    public void error() {
        int i = 5 / 0;
    }

}
