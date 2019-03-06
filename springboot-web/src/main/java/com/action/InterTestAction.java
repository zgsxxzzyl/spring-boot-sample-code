package com.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试拦截器
 */
@RestController
@RequestMapping("/inter")
public class InterTestAction {

    @GetMapping("/d")
    public String test() {
        return "拦截器拦截";
    }
}
