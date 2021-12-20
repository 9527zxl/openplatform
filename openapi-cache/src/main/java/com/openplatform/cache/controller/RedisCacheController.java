package com.openplatform.cache.controller;

import com.openplatform.cache.service.RedisCacheService;
import com.openplatform.cache.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/cache")
public class RedisCacheController {
    @Autowired
    private RedisCacheService cacheService;


    @RequestMapping("/setString")
    public boolean setString(@RequestParam String key, @RequestParam String value, @RequestParam long survivalTime) {
        KeyUtils.exit(key);
        return cacheService.setString(key, value, survivalTime);
    }


    @RequestMapping("/expireKey")
    public boolean expireKey(@RequestParam String key, @RequestParam long survivalTime) {
        KeyUtils.exit(key);
        return cacheService.expireKey(key, survivalTime);
    }


    @RequestMapping("/getString/{key}")
    public String getString(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.getString(key);
    }


    @RequestMapping("/incrString/{key}")
    public long incrString(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.incrString(key);
    }


    @RequestMapping("/decrString/{key}")
    public long decrString(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.decrString(key);
    }


    @RequestMapping("/incrByString")
    public long incrByString(@RequestParam String key, @RequestParam int increment) {
        KeyUtils.exit(key);
        return cacheService.incrByString(key, increment);
    }


    @RequestMapping("/decrByString")
    public long decrByString(@RequestParam String key, @RequestParam int decrement) {
        KeyUtils.exit(key);
        return cacheService.decrByString(key, decrement);
    }


    @RequestMapping("/setNxString")
    public boolean setNxString(@RequestParam String key, @RequestParam String value) {
        KeyUtils.exit(key);
        return cacheService.setNxString(key, value);
    }


    @RequestMapping("/hSetHash")
    public boolean hSetHash(@RequestParam String key, @RequestParam String field, @RequestParam String value) {
        KeyUtils.exit(key);
        return cacheService.hSetHash(key, field, value);
    }


    @RequestMapping("/hGetHash")
    public Object hGetHash(@RequestParam String key, @RequestParam String field) {
        KeyUtils.exit(key);
        return cacheService.hGetHash(key, field);
    }


    @RequestMapping("/hmSetHash")
    public boolean hmSetHash(@RequestParam String key, @RequestBody Map<String, Object> map) {
        KeyUtils.exit(key);
        return cacheService.hmSetHash(key, map);
    }


    @RequestMapping("/hSetNxHash")
    public boolean hSetNxHash(@RequestParam String key, @RequestParam String field, @RequestParam String value) {
        KeyUtils.exit(key);
        return cacheService.hSetNxHash(key, field, value);
    }


    @RequestMapping(value = "/hGetHashAll",produces = "application/json")
    public Map<Object, Object> hGetHashAll(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.hGetHashAll(key);
    }


    @RequestMapping("/sAddSet")
    public long sAddSet(@RequestParam String key, @RequestParam Object member) {
        KeyUtils.exit(key);
        return cacheService.sAddSet(key, member);
    }


    @RequestMapping("/sAddSetAll")
    public long sAddSetAll(@RequestParam String key, @RequestBody List<Object> members) {
        KeyUtils.exit(key);
        return cacheService.sAddSetAll(key, members);
    }


    @RequestMapping(value = "/sMembersSetAll/{key}",produces = "application/json")
    public Set<Object> sMembersSetAll(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.sMembersSetAll(key);
    }
}
