package com.web;

import com.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @ResponseBody
    @RequestMapping("/sv1")
    public void ac1() {
        sampleService.saveDemo();
    }
}
