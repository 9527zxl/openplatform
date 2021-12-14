package com.openplatform.cache.service;

import java.util.List;
import java.util.Map;

public interface RedisCacheService {

    /**
     * redis添加string类型的值
     * @param key
     * @param value
     * @param survivalTime  0表示没有设置生存时间
     * @return
     */
    boolean setString(String key,String value,long survivalTime);

    /**
     * 设置key的生存时间，单位为秒
     * @param key
     * @param survivalTime
     * @return
     */
    boolean expireKey(String key,long survivalTime);

    /**
     * redis通过key获取string类型的值
     * @param key
     * @return
     */
    boolean getString(String key);

    /**
     * redis string类型 自增命令（自增1）
     * @param key
     */
    void incrString(String key);

    /**
     * redis string类型 自减命令（自减1）
     * @param key
     */
    void decrString(String key);

    /**
     * redis string类型 自增指定数量
     * @param key
     * @param increment
     */
    void incrByString(String key,int increment);

    /**
     * redis string类型 自减指定数量
     * @param key
     * @param decrement
     */
    void decrByString(String key,int decrement);

    /**
     * redis string类型 判断key值存不存在，key如果不存在就和set命令一样
     * @param key
     * @param value
     * @return
     */
    boolean setNxString(String key,String value);

    /**
     * redis 通过key存储hash类型的值
     * @param key
     * @param field
     * @param value
     * @return
     */
    boolean hSetHash(String key,String field,Object value);

    /**
     * redis hash类型 获取数据
     * @param key
     * @param field
     * @return
     */
    Object hGetHash(String key,String field);

    /**
     * redis hash类型 批量存储数据
     * @param key
     * @param map
     * @return
     */
    boolean hmSetHash(String key, Map<String,Object> map);

    /**
     * redis hash类型 设置值（如果key-field不存在，那么就正常添加，如果存在，什么事都不做）
     * @param key
     * @param field
     * @param value
     * @return
     */
    boolean hSetNxHash(String key,String field,Object value);

    /**
     * redis hash类型 获取当前hash结构中的全部field和value
     * @param key
     * @return
     */
    Map<String, Object> hGetHashAll(String key);

    /**
     * redis set类型 存储单个数据
     * @param key
     * @param member
     * @return
     */
    boolean sAddSet(String key, Object member);

    /**
     * redis set类型 存储多个数据
     * @param key
     * @param members
     * @return
     */
    boolean sAddSet(String key, List<Object> members);

    /**
     * redis set类型 获取全部数据
     * @param key
     * @return
     */
    List<Object> sMembersSetAll(String key);


}
