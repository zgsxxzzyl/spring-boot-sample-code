package com.web;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TPSLimiter {

    private int size;

    private int sum;

    private int second;

    private ConcurrentLinkedDeque<LocalDateTime> deque;

    public TPSLimiter(int size, int second) {
        this.size = size;
        this.second = second;
        this.deque = new ConcurrentLinkedDeque<>();
    }

    public void acquire() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start;
        while (!push(now)) {
            now = LocalDateTime.now();
            start = now.minusSeconds(second);
            if (deque.size() > 0) {
                if (deque.getFirst().isBefore(start)) {
                    deque.removeFirst();
                }
            }
            if (push(now)) {
                break;
            }
        }
    }

    public boolean push(LocalDateTime now) {
        if (deque.size() < size) {
            deque.addLast(now);
            return true;
        }
        return false;
    }

}
