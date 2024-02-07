package com.web;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 限流接口
 * <p>
 * 平滑突发限流(SmoothBursty)和平滑预热限流(SmoothWarmingUp)实现。
 */
@RestController
@RequestMapping("/rateLimiter")
public class RateLimiterController {
    final Semaphore semaphore = new Semaphore(5);
    RateLimiter smoothWarmingUp = RateLimiter.create(10, 5, TimeUnit.SECONDS);
    @Resource
    RateLimiter smoothBursty;

    /**
     * 平滑突发限流
     */
    @GetMapping("/smoothBursty")
    public void smoothBursty() {
        if (smoothBursty.tryAcquire()) {
            System.out.println(LocalDateTime.now());
        }
    }

    @GetMapping("/semaphore")
    public void semaphore() {
        if (semaphore.tryAcquire()) {
            System.out.println(LocalDateTime.now());
            semaphore.release();
        }
    }

    /**
     * 平滑预热限流
     */
    public void smoothWarmingUp() {
        smoothBursty.acquire();
    }
}
