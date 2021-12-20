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

    /**
     * redis添加string类型的值
     * @param key
     * @param value
     * @param survivalTime 0表示没有设置生存时间
     * @return
     */
    @RequestMapping("/setString")
    public boolean setString(@RequestParam String key, @RequestParam String value, @RequestParam long survivalTime) {
        KeyUtils.exit(key);
        return cacheService.setString(key, value, survivalTime);
    }

    /**
     * 设置key的生存时间，单位为秒
     * @param key
     * @param survivalTime
     * @return
     */
    @RequestMapping("/expireKey")
    public boolean expireKey(@RequestParam String key, @RequestParam long survivalTime) {
        KeyUtils.exit(key);
        return cacheService.expireKey(key, survivalTime);
    }

    /**
     * redis通过key获取string类型的值
     * @param key
     * @return
     */
    @RequestMapping("/getString/{key}")
    public String getString(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.getString(key);
    }

    /**
     * redis string类型 自增命令（自增1）
     * @param key
     * @return
     */
    @RequestMapping("/incrString/{key}")
    public long incrString(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.incrString(key);
    }

    /**
     * redis string类型 自减命令（自减1）
     * @param key
     * @return
     */
    @RequestMapping("/decrString/{key}")
    public long decrString(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.decrString(key);
    }

    /**
     * redis string类型 自增指定数量
     * @param key
     * @param increment
     * @return
     */
    @RequestMapping("/incrByString")
    public long incrByString(@RequestParam String key, @RequestParam int increment) {
        KeyUtils.exit(key);
        return cacheService.incrByString(key, increment);
    }

    /**
     * redis string类型 自减指定数量
     * @param key
     * @param decrement
     * @return
     */
    @RequestMapping("/decrByString")
    public long decrByString(@RequestParam String key, @RequestParam int decrement) {
        KeyUtils.exit(key);
        return cacheService.decrByString(key, decrement);
    }

    /**
     * redis string类型 判断key值存不存在，key如果不存在就和set命令一样
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/setNxString")
    public boolean setNxString(@RequestParam String key, @RequestParam String value) {
        KeyUtils.exit(key);
        return cacheService.setNxString(key, value);
    }

    /**
     * redis 通过key存储hash类型的值
     * @param key
     * @param field
     * @param value
     * @return
     */
    @RequestMapping("/hSetHash")
    public boolean hSetHash(@RequestParam String key, @RequestParam String field, @RequestParam String value) {
        KeyUtils.exit(key);
        return cacheService.hSetHash(key, field, value);
    }

    /**
     * redis hash类型 获取数据
     * @param key
     * @param field
     * @return
     */
    @RequestMapping("/hGetHash")
    public Object hGetHash(@RequestParam String key, @RequestParam String field) {
        KeyUtils.exit(key);
        return cacheService.hGetHash(key, field);
    }

    /**
     * redis hash类型 批量存储数据
     * @param key
     * @param map
     * @return
     */
    @RequestMapping("/hmSetHash")
    public boolean hmSetHash(@RequestParam String key, @RequestBody Map<String, Object> map) {
        KeyUtils.exit(key);
        return cacheService.hmSetHash(key, map);
    }

    /**
     * redis hash类型 设置值（如果key-field不存在，那么就正常添加，如果存在，什么事都不做）
     * @param key
     * @param field
     * @param value
     * @return
     */
    @RequestMapping("/hSetNxHash")
    public boolean hSetNxHash(@RequestParam String key, @RequestParam String field, @RequestParam String value) {
        KeyUtils.exit(key);
        return cacheService.hSetNxHash(key, field, value);
    }

    /**
     * redis hash类型 获取当前hash结构中的全部field和value
     * @param key
     * @return
     */
    @RequestMapping(value = "/hGetHashAll",produces = "application/json")
    public Map<Object, Object> hGetHashAll(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.hGetHashAll(key);
    }

    /**
     * redis set类型 存储单个数据
     * @param key
     * @param member
     * @return
     */
    @RequestMapping("/sAddSet")
    public long sAddSet(@RequestParam String key, @RequestParam Object member) {
        KeyUtils.exit(key);
        return cacheService.sAddSet(key, member);
    }

    /**
     * redis set类型 存储多个数据
     * @param key
     * @param members
     * @return
     */
    @RequestMapping("/sAddSetAll")
    public long sAddSetAll(@RequestParam String key, @RequestBody List<Object> members) {
        KeyUtils.exit(key);
        return cacheService.sAddSetAll(key, members);
    }

    /**
     * redis set类型 获取全部数据
     * @param key
     * @return
     */
    @RequestMapping(value = "/sMembersSetAll/{key}",produces = "application/json")
    public Set<Object> sMembersSetAll(@PathVariable String key) {
        KeyUtils.exit(key);
        return cacheService.sMembersSetAll(key);
    }
}
