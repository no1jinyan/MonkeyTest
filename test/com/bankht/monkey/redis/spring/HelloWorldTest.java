package com.bankht.monkey.redis.spring;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.ShardInfo;

public class HelloWorldTest extends TestCase {
	ApplicationContext context;

	protected void setUp() throws Exception {
		super.setUp();
		context = new ClassPathXmlApplicationContext(
				"com/bankht/monkey/redis/helloworld/applicationContext.xml");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHelloWorld() {
//		ShardedJedisPool pool = (ShardedJedisPool) context
//				.getBean("shardedJedisPool");
//		ShardedJedis jedis = pool.getResource();
//		String keys = "name";
//
//		// 删数据
////		jedis.del(keys);
//		// 存数据
////		jedis.set(keys, "jinyan");
//		// 取数据
//		String value = jedis.get(keys);
//
//		System.out.println(value);
//
//		// 释放对象池
//		pool.returnResource(jedis);
	}
	
	public void testShardedJedisPool() {
		ShardedJedisPool pool = (ShardedJedisPool) context
			.getBean("shardedJedisPool");

        for(int i=0; i<100; i++){
           String key =generateKey();

           //key += "{aaa}";

           ShardedJedis jds =null;
           try {
               jds =pool.getResource();
//               System.out.println(key+":"+jds.getShard(key).getClient().getHost()+":"+jds.getShard(key).getClient().getPort());
//               System.out.println(jds.set(key,"1111111111111111111111111111111"));
//               String text = jds.getShard(key).get("name");
//               System.out.println(jds.getShard(key).getClient().getHost()+ ":" + jds.getShard(key).getClient().getPort() + " value:" + text);
//               text = null;
               Collection<JedisShardInfo> list = (Collection<JedisShardInfo>) jds.getAllShardInfo();
               for (JedisShardInfo jedisShardInfo : list) {
				jedisShardInfo.toString();
			}
           }catch (Exception e) {
               e.printStackTrace();
           }

           finally{
               pool.returnResource(jds);
           }
        }
        
//        pool.close();
//        pool.destroy();
    }

    private static int index = 1;

    public static String generateKey(){
        return String.valueOf(Thread.currentThread().getId())+"_"+(index++);
    }
}
