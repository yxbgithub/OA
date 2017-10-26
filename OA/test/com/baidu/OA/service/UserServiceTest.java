package com.baidu.OA.service;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.OA.model.Department;
import com.baidu.OA.model.Role;
import com.baidu.OA.model.User;
import com.baidu.OA.service.DepartmentService;
import com.baidu.OA.service.RoleService;
import com.baidu.OA.service.UserService;
@ContextConfiguration(locations="classpath:beans.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)

public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	private UserService userService;
	private DepartmentService departmentService;
	private RoleService roleService;
	
	
	@Test
	@Rollback(false)
	public final void test() {
		/*userService.save(new User());*/
		Department department = new Department();
		department.setName("d1");
		
		/*Set<User> users = new HashSet<User>();
		User user = new User();
		user.setId(1);
		
		department.setUsers(users);
		
		departmentService.add(department);*/
		
		User user = new User();
		user.setId(2);
		user.setName("u1");
		
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setName("r1");
		role.setId(1);
		
		Role role1 = new Role();
		role1.setName("r2");
		role1.setId(2);
		
		roleService.add(role);
		roleService.add(role1);
		
		roles.add(role);
		roles.add(role1);
		user.setRoles(roles);
		
		user.setDepartment(department);
		departmentService.add(department);
		
		userService.add(user);
		/*roleService.delete(role);*/
		/*userService.delete(user);*/
		
		
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	

}
