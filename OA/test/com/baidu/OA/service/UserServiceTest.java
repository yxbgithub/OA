package com.baidu.OA.service;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baidu.OA.model.User;


public class UserServiceTest {

	@Test
	public final void test() {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService)factory.getBean("userService");
		userService.save(new User());
		
	}

}
