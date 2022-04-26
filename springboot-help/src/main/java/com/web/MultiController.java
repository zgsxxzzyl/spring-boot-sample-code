package com.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multi")
public class MultiController {

    @RequestMapping(params = "method=req1")
    public void req1() {
        System.out.println("req1");
    }

    @RequestMapping(params = "method=req2")
    public void req2() {
        System.out.println("req2");
    }
}
