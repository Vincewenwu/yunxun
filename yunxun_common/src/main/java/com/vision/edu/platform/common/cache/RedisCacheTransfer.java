package com.vision.edu.platform.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @title 
 * @filename RedisCacheTransfer.java
 * @author XieFan
 * @date 2017年6月27日 上午10:46:22
 * @version 1.0
 */
public class RedisCacheTransfer {
	
	@Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
