package com.czy.myoa.dao.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czy.myoa.domain.User;
import com.czy.myoa.service.UserService;

public class BaseDaoTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void saveTest() {
		UserService userService = (UserService) ac.getBean("userServiceImpl");
		User user = new User();
		user.setName("超级管理员");
		user.setLoginName("admin");
		user.setPassword(DigestUtils.md5Hex("admin")); // 要使用MD5摘要
		userService.save(user);
	}

}
