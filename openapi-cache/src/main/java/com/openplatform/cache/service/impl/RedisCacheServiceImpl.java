package com.openplatform.cache.service.impl;

import com.openplatform.cache.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean setString(String key, String value, long survivalTime) {
        if (survivalTime == 0) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            survivalTime = Math.abs(survivalTime);
            redisTemplate.opsForValue().set(key, value, survivalTime, TimeUnit.MILLISECONDS);
        }
        return true;
    }

    @Override
    public boolean expireKey(String key, long survivalTime) {
        return redisTemplate.expire(key, survivalTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public long incrString(String key) {
        Long increment = redisTemplate.opsForValue().increment(key);
        return increment;
    }

    @Override
    public long decrString(String key) {
        Long decrement = redisTemplate.opsForValue().decrement(key);
        return decrement;
    }

    @Override
    public long incrByString(String key, int increment) {
        return redisTemplate.opsForValue().increment(key, increment);
    }

    @Override
    public long decrByString(String key, int decrement) {
        return redisTemplate.opsForValue().decrement(key, decrement);
    }

    @Override
    public boolean setNxString(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public boolean hSetHash(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
        return true;
    }

    @Override
    public Object hGetHash(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    @Override
    public boolean hmSetHash(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
        return true;
    }

    @Override
    public boolean hSetNxHash(String key, String field, Object value) {
        return redisTemplate.opsForHash().putIfAbsent(key, field, value);
    }

    @Override
    public Map<Object, Object> hGetHashAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public long sAddSet(String key, Object member) {
        Long add = redisTemplate.opsForSet().add(key, member);
        return add;
    }

    @Override
    public long sAddSetAll(String key, List<Object> members) {
        return redisTemplate.opsForSet().add(key, members.toArray());
    }

    @Override
    public Set<Object> sMembersSetAll(String key) {
        Set<Object> members = redisTemplate.opsForSet().members(key);
        return members;
    }
}
