package com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/")
    public void index() {
        logger.info("记录日志");
    }

    @GetMapping("/error")
    public void error() {
        try {
            int i = 123 / 0;
        } catch (Exception e) {
            logger.error("错误日志：{}{}", "测试", e);
        }
    }
}
