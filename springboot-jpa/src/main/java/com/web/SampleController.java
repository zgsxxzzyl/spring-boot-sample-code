package com.web;

import com.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.SQLException;

@Controller
public class SampleController {
    @Resource
    private SampleService sampleService;

    @ResponseBody
    @RequestMapping("/sv1")
    public void ac1() {
        sampleService.saveDemo();
    }

    @ResponseBody
    @RequestMapping("/problem")
    public void problem() throws SQLException {
        sampleService.problem();
    }
}
