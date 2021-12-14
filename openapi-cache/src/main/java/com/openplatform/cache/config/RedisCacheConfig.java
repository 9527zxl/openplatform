package com.openplatform.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

    //自定义缓存key生成策略
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params)->{
            StringBuilder builder = new StringBuilder();
            builder.append(target.getClass().getName());
            builder.append(method.getName());
            for (Object param : params) {
                builder.append(param.getClass().getName());
            }
            return builder.toString();
        };
    }

    //缓存管理设置，管理缓存中数据安全性
    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory connectionFactory) {
        //以锁写入的方式创建我们的写入对象，保证数据安全
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        //创建默认的缓存配置对象
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        //根据我们的默认配置和写入方式创建缓存的管理器
        RedisCacheManager cacheManager = new RedisCacheManager(writer,configuration);
        return cacheManager;
    }

    //重写RedisTemp对象,创建模板对象
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);//设置要连接的 redis

        //设置key的序列化方式
        //创建一个字符串的序列化方式,所有的数据会被序列为字符串
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //设置 key 的序列化方式为字符串
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //设置 hash 的 key 序列化方式为 string
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        //设置value的序列化方式
        //创建一个解析为 json 的序列化对象
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //因为 jackson 中是使用ObjectMapper来进行序列化的,所以我们需要设置给ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);//设置所有非 final 修饰的变量都可以被序列化

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        //设置值的序列化方式为 json
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}
