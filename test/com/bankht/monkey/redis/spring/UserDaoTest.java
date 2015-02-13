package com.bankht.monkey.redis.spring;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest extends TestCase {
	private ApplicationContext context;

	protected void setUp() throws Exception {
		super.setUp();
		context = new ClassPathXmlApplicationContext(
				"com/bankht/monkey/redis/spring/applicationContext.xml");
	}

	@Test
	public void testSave() {
		UserDao dao = (UserDao) context.getBean("userDao");
		User user = new User();
		user.setName("jinyan");
		user.setPassword("jinyan's");
		dao.save(user);
		
		assertEquals(true, true);
	}

}
