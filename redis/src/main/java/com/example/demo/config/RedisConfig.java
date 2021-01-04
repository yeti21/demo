package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/*
redis应用场景：缓存，任务队列，网站访问统计...
key
* value可以是 字符串(String), 哈希(Hash), 列表(list), 集合(sets) 和 有序集合(sorted sets)
* 配置序列化器，将对象的状态信息转为存储或传输的形式需要序列化
* 配置redis的key跟value的序列化方式， 避免key跟value显示不是正常字符
* spring提供的序列化器
* Jackson2JsonRedisSerializer
  JdkSerializationRedisSerializer
  OxmSerializer
  StringRedisSerializer
  GenericToStringRedisSerializer
  GenericJackson2JsonRedisSerializer
*
* */
@Configuration
/*
*开启基于注解的缓存
* */
@EnableCaching
/*
* spring只对spring.factory文件下的配置类进行排序
* @AutoConfigureAfter 先加载括号内的类，再加载当前类
* */
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    /*
    * 自定义redisTemplate,默认情况下的模板只能支持RedisTemplate<String, String>，也就是只能存入字符串
    * */
    @Bean
    RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory factory){
       RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();

       redisTemplate.setConnectionFactory(factory);

       Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        // 设置值（value）的序列化采用Jackson2JsonRedisSerializer。
       redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
       redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
        // 设置键（key）的序列化采用StringRedisSerializer。
       redisTemplate.setKeySerializer(stringRedisSerializer);
       redisTemplate.setHashKeySerializer(stringRedisSerializer);

       redisTemplate.afterPropertiesSet();
    return  redisTemplate;
    }



}
