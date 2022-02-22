package com.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/refresh/config")
public class RefreshConfigController {

    @Value("${config.change}")
    private String change;

    @RequestMapping("/change")
    public String getChangeValue() {
        return this.change;
    }

}
