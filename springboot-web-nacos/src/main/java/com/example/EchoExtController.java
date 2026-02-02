package com.example;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这种场景不生效，有待查明原因
 */
@RestController
@RequestMapping("ext")
class EchoExtController {

    @NacosValue(value = "${config.textExt}", autoRefreshed = true)
    private String textExt;

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        return "Hello Nacos Discovery " + textExt;
    }
}