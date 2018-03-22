package com.ssm.common.redis;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;
 
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringRedisClientImpl implements SpringRedisClient,Serializable {
	
    private static final long serialVersionUID = -4213002642362857373L;
    
	@Resource
    private RedisTemplate<String, Object> redisTemplate;
 
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
 
    @Override
    public void setKey(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
    }
 
    @Override
    public Object getKey(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }
 
    @Override
    public void incr(String key) {
        this.redisTemplate.opsForValue().increment(key, 1);
    }
 
    @Override
    public void lPush(String key, String value) {
        this.redisTemplate.opsForList().leftPush(key, value);
    }
 
    @Override
    public boolean checkKey(String key) {
        return this.redisTemplate.hasKey(key);
    }
 
    @Override
    public Object lIndex(String key) {
        return this.redisTemplate.opsForList().index(key, 0);
    }
 
    @Override
    public Long lLength(String key) {
        return this.redisTemplate.opsForList().size(key);
    }
 
    @Override
    public String lPop(String key) {
        return (String) this.redisTemplate.opsForList().leftPop(key);
    }
 
    @Override
    public Set<String> getKeys(String pattern) {
        return this.redisTemplate.keys(pattern);
    }

	@Override
	public void deleteKey(String key) {
		this.redisTemplate.delete(key);
	}

	@Override
	public void deleteKeys(Collection<String> keys) {
		this.redisTemplate.delete(keys);
	}
 
}
