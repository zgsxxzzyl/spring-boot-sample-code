package com.web;

import com.bean.JsonBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/json")
public class JsonRestController {

    @GetMapping("/test")
    public JsonBean test() {
        JsonBean jsonBean = new JsonBean();
        jsonBean.setId(1);
        jsonBean.setCurTime(new Date());
        jsonBean.setName("mirror");
        return jsonBean;
    }
}
