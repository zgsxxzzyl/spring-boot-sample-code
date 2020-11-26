package com.scenes.a;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @AutoFit("AService")
    public AService aService;

    @GetMapping("/demo")
    public String demo(){
        return aService.whoami("yeah!");
    }
}
