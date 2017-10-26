package com.baidu.OA.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.OA.model.Role;
import com.baidu.OA.model.User;
import com.baidu.OA.service.RoleService;
import com.baidu.OA.service.UserService;
@ContextConfiguration(locations="classpath:beans.xml")
@TransactionConfiguration(transactionManager="txManager",defaultRollback=true)
public class RoleServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	RoleService roleService;
	UserService userService;

	@Test
	@Rollback(false)
	public final void test() {
		/*List<Role> roles = roleService.findAll();
		for(Role role : roles) {
			System.out.println(role.getName());
		}*/
		
		List<User> users = userService.findAll();
		for(User user : users) {
			System.out.println(user.getId());
		}
	}
	
	public RoleService getRoleService() {
		return roleService;
	}
	
	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
