package com.example.demo.Service.Impl;

import com.example.demo.Service.UserService;
import com.example.demo.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserImpl implements UserService {

    public  static Map<Long,User> map=new HashMap<Long,User>();
    static {
        map.put(1L,new User(1L,"user1"));
        map.put(2L,new User(2L,"user2"));
        map.put(3L,new User(3L,"user3"));
    }


    /**
     *@CachePut
     *执行方法体 - 将结果缓存起来 ,适用于更新数据的方法。
     * value对应ehcache xml文件的cache标签name属性
     * key默认值按照KeyGenerator的生成策略
     */
    @CachePut(value = "user",key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        map.put(user.getId(),user);
        return user;
    }

    /**
     *查找缓存 - 有就返回 -没有就执行方法体 - 将结果缓存起来,适用于查询数据的方法。
     */
    @Cacheable(value = "user",key = "#id")
    @Override
    public User get(Long id) {
        return map.get(id);
    }


    @CacheEvict(value = "user",key = "#id")
    @Override
    public void delete(Long id) {
        map.remove(id);
    }

}
