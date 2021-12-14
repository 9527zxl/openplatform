package com.openplatform.cache.service.impl;

import com.openplatform.cache.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean setString(String key, String value, long survivalTime) {
        redisTemplate.opsForValue().set(key,value,survivalTime);
        return false;
    }

    @Override
    public boolean expireKey(String key, long survivalTime) {
        
        return false;
    }

    @Override
    public boolean getString(String key) {
        return false;
    }

    @Override
    public void incrString(String key) {

    }

    @Override
    public void decrString(String key) {

    }

    @Override
    public void incrByString(String key, int increment) {

    }

    @Override
    public void decrByString(String key, int decrement) {

    }

    @Override
    public boolean setNxString(String key, String value) {
        return false;
    }

    @Override
    public boolean hSetHash(String key, String field, Object value) {
        return false;
    }

    @Override
    public Object hGetHash(String key, String field) {
        return null;
    }

    @Override
    public boolean hmSetHash(String key, Map<String, Object> map) {
        return false;
    }

    @Override
    public boolean hSetNxHash(String key, String field, Object value) {
        return false;
    }

    @Override
    public Map<String, Object> hGetHashAll(String key) {
        return null;
    }

    @Override
    public boolean sAddSet(String key, Object member) {
        return false;
    }

    @Override
    public boolean sAddSet(String key, List<Object> members) {
        return false;
    }

    @Override
    public List<Object> sMembersSetAll(String key) {
        return null;
    }
}
