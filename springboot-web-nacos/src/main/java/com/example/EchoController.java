package com.example;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class EchoController {

    @Value("${config.text}")
    private String text;

    /**
     * 动态获取参数
     *
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        return "Hello Nacos Discovery :" + text;
    }

    /**
     * 接口调用方式
     *
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/echoLocal", method = RequestMethod.GET)
    public String echoLocal() throws NacosException {
        ConfigService configService = NacosFactory.createConfigService("192.168.96.83:8848");
        String content = configService.getConfig("springboot-web-nacos-dev.yaml", "DEFAULT_GROUP", 5000);
        System.out.println(content);
        return "Hello Nacos Discovery :</br>" + content;
    }
}