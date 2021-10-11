package com;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.UnsupportedEncodingException;

public class StringRedisSerializer implements RedisSerializer<String> {

    @Override
    public byte[] serialize(String s) throws SerializationException {

        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        try {
            if (bytes == null) {
                return null;
            }
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
