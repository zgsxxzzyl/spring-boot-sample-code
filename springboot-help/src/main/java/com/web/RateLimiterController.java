package com.web;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 限流接口
 * <p>
 * 平滑突发限流(SmoothBursty)和平滑预热限流(SmoothWarmingUp)实现。
 */
@RestController
@RequestMapping("/rateLimiter")
public class RateLimiterController {
    RateLimiter smoothBursty = RateLimiter.create(10);
    RateLimiter smoothWarmingUp = RateLimiter.create(10, 5, TimeUnit.SECONDS);

    /**
     * 平滑突发限流
     */
    public void smoothBursty() {
        smoothBursty.acquire(1);
    }

    /**
     * 平滑预热限流
     */
    public void smoothWarmingUp() {
        smoothBursty.acquire(1);
    }
}
