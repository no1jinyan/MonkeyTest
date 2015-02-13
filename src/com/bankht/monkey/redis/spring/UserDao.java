package com.bankht.monkey.redis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class UserDao {
	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	public void save(final User user) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(redisTemplate.getStringSerializer().serialize(
						"user.usename." + user.getName()), redisTemplate
						.getStringSerializer().serialize(user.getPassword()));
				return null;
			}
		});
	}
}
