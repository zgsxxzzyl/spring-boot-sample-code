package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/server")
    public String hi(@RequestParam String name) {
        return helloService.remoteService(name);
    }
}
