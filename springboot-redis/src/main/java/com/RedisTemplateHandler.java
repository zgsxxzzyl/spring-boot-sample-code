package com;

import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RedisTemplateHandler {
    @Resource
    private RedisTemplate redisTemplate;

    public Set<String> scan(String pattern) {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisClusterConnection clusterConnection = connectionFactory.getClusterConnection();
        Iterable<RedisClusterNode> redisClusterNodes = clusterConnection.clusterGetNodes();
        Iterator<RedisClusterNode> iterator = redisClusterNodes.iterator();
        Set<String> keys = new HashSet<>();
        while (iterator.hasNext()) {
            RedisClusterNode next = iterator.next();
            Cursor<byte[]> scan = clusterConnection.scan(next,
                    ScanOptions.scanOptions().match(pattern).count(Integer.MAX_VALUE).build());
            while (scan.hasNext()) {
                keys.add(new String(scan.next(), StandardCharsets.UTF_8));
            }
        }
        return keys;
    }


}
