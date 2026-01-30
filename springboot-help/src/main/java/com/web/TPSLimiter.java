package com.web;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * TPS限流工具待完善
 */
public class TPSLimiter {

    private int size;

    private Long second;

    private ConcurrentLinkedDeque<Long> deque;

    public TPSLimiter(int size, Long second) {
        this.size = size;
        this.second = second;
        this.deque = new ConcurrentLinkedDeque<>();
    }

    public synchronized void acquire() {
        Long now, start;
        for (now = System.nanoTime(); !push(now); now = System.nanoTime()) {
            if (deque.size() > 0) {
                start = now - second;
                if (deque.getFirst() < start) {
                    deque.removeFirst();
                }
            }
            if (push(now)) {
                break;
            }
        }
    }

    private boolean push(Long now) {
        if (deque.size() < size) {
            deque.addLast(now);
            return true;
        }
        return false;
    }
}
