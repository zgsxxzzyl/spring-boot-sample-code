package com.web;

import com.annotation.AutoFit;
import com.service.AService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/annotation")
public class AnnotationRestController {
    @AutoFit("aService")
    public AService aService;

    @GetMapping("/test")
    public String demo() {
        return aService.whoami("yeah!");
    }
}
