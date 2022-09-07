package com.util.ratelimiter;

import java.util.TreeMap;

public class RateLimiter {
    public static void main(String[] args) {
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.subMap(0L, 1000L);
    }
}
