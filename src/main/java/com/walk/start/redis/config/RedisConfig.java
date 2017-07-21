package com.walk.start.redis.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	String host;
	@Value("${spring.redis.port}")
	int port;
	@Value("${spring.redis.password}")
	String password;
	@Value("${spring.redis.pool.max-total}")
	int maxTotal;
	@Value("${spring.redis.pool.max-wait}")
	int maxWaitMillis;
	@Value("${spring.redis.pool.max-idle}")
	int maxIdle;
	@Value("${spring.redis.pool.test-onBorrow}")
	boolean testOnBorrow;
	@Value("${spring.redis.pool.test-onReturn}")
	boolean testOnReturn;
	@Value("${spring.redis.timeout}")
	int timeout;

	@SuppressWarnings("resource")
	@Bean
	public ShardedJedis getSharededJedis(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMaxWaitMillis(maxWaitMillis);
		poolConfig.setMaxTotal(maxTotal);
		poolConfig.setTestOnBorrow(testOnBorrow);
		poolConfig.setTestOnReturn(testOnReturn);
		
		JedisShardInfo sharedInfo = new JedisShardInfo(host,port,timeout);
		sharedInfo.setPassword(password);
		List<JedisShardInfo> sharedList = new ArrayList<>();
		sharedList.add(sharedInfo);
		ShardedJedisPool jedisPool = new ShardedJedisPool(poolConfig,sharedList);
		
		return jedisPool.getResource();
	}
	
	/*public void closeRedisResource(){
		ShardedJedis jedis = getSharededJedis();
		
		if(jedis != null){
			jedis.close();
		}
	}*/
}
