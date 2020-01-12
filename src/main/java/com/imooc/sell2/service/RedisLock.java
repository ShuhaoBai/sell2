package com.imooc.sell2.service;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Shuhao Bai on 1/11/20
 */

@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * lock
     * @param key
     * @param value current time + time overdue   当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value){
        if(redisTemplate.opsForValue().setIfAbsent(key, value)){
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if(!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁unlock
     * @param key
     * @param value
     */
    public void unlock(String key, String value){
        String currentValue = redisTemplate.opsForValue().get(key);
        try{
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("Redis Distributed Lock Error, {}", e);
        }

    }
}
