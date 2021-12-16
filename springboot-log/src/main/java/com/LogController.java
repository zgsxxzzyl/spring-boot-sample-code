package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping("/show")
    public LoggerMessage test() {
        LoggerMessage poll = LoggerQueue.getInstance().poll();
        return poll;
    }
}
