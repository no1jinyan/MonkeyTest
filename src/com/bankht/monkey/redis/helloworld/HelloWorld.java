package com.bankht.monkey.redis.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class HelloWorld {
//    private static JedisPool pool; 
    private static ShardedJedisPool pool;
    
    static {  
        ResourceBundle bundle = null;  
        try {
        	bundle = ResourceBundle.getBundle("redis"); 
		} catch (Exception e) {
			System.out.println("[redis.properties] is not found!");
		}
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(Integer.valueOf(bundle  
                .getString("redis.pool.maxActive")));  
        config.setMaxIdle(Integer.valueOf(bundle  
                .getString("redis.pool.maxIdle")));  
        config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait")));  
        config.setTestOnBorrow(Boolean.valueOf(bundle  
                .getString("redis.pool.testOnBorrow")));  
        config.setTestOnReturn(Boolean.valueOf(bundle  
                .getString("redis.pool.testOnReturn")));  
//        pool = new JedisPool(config, bundle.getString("redis.ip"),  
//                Integer.valueOf(bundle.getString("redis.port")));  

		JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle
				.getString("redis1.ip"), Integer.valueOf(bundle
				.getString("redis.port")));
//		JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle
//				.getString("redis2.ip"), Integer.valueOf(bundle
//				.getString("redis.port")));
        
        List<JedisShardInfo> shardInfoList = new ArrayList<JedisShardInfo>();
        shardInfoList.add(jedisShardInfo1);
//        shardInfoList.add(jedisShardInfo2);
        
        pool = new ShardedJedisPool(config, shardInfoList);
    }  
    
	public static void main(String args[]){
//		Jedis jedis = pool.getResource();  
		ShardedJedis jedis = pool.getResource();
		String keys = "name";  
		  
		// 删数据  
		jedis.del(keys);  
		// 存数据  
		jedis.set(keys, "jinyan");  
		// 取数据  
		String value = jedis.get(keys);  
		  
		System.out.println(value); 
		
		// 释放对象池
		pool.returnResource(jedis);  
	}
	
	
}
