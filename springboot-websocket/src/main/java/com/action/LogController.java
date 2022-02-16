package com.action;

import com.log.LoggerMessage;
import com.log.LoggerQueue;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController("/log")
public class LogController {
    @GetMapping("/load")
    public LoggerMessage load() {
        return LoggerQueue.getInstance().poll();
    }
}
