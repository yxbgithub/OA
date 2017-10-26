package com.baidu.OA.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.model.Department;
import com.baidu.OA.model.Role;
import com.baidu.OA.model.User;
import com.baidu.OA.service.DepartmentService;
import com.baidu.OA.service.RoleService;
import com.baidu.OA.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private  UserService userService;
	private DepartmentService departmentService;
	private RoleService roleService;
	private User user = new User();
	
	public String list() {
		List<User> users = null;
		users = userService.findAll();
		ActionContext.getContext().put("users", users);
		return "list";
	}



	public String addUI() {
		List<Department> departments =null;
		departments = departmentService.findAll();
		ActionContext.getContext().put("departments", departments);
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		return "addUI";
	}
	
	public String add() {
		userService.add(user);
		return "toList";
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService() {
		return userService;
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



	@Override
	public User getModel() {
		return user;
	}
}
