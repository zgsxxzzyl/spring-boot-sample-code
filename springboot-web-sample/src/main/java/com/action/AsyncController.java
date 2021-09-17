package com.action;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 异步处理请求
 */
@EnableAsync
public class AsyncController {

    @Async
    public void demo() {
    }
}
