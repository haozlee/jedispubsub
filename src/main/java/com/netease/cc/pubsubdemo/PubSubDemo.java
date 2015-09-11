package com.netease.cc.pubsubdemo;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class PubSubDemo 
{
    public static void main( String[] args )
    {
    	// 替换成你的reids地址和端口
    	String redisIp = "192.168.229.154";
    	int reidsPort = 6379;
    	JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
    	System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));
    	
		SubThread subThread = new SubThread(jedisPool);
		subThread.start();
		
		Publisher publisher = new Publisher(jedisPool);
		publisher.start();
    }
}
