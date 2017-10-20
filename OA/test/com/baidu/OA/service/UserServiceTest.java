package com.baidu.OA.service;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.OA.model.User;
@ContextConfiguration(locations="classpath:beans.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)

public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	private UserService userService;
	
	@Test
	@Rollback(true)
	public final void test() {
		userService.save(new User());
		
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
