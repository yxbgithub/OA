package com.baidu.OA.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.Department;
import com.baidu.OA.model.Role;
import com.baidu.OA.model.User;
import com.baidu.OA.util.DepartmentUtil;
import com.opensymphony.xwork2.ActionContext;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ModelDrivenAction<User>{
	private Integer[] roleIds;
	private Integer departmentId;
	
	public String list() {
		List<User> users = userService.findAll();
		ActionContext.getContext().put("users", users);
		return "list";
	}


	public String addUI() {
		//准备要显示的部门树状接结构数据
		List<Department> topDepartments = departmentService.findTopLevelDepartment();
		List<Department> treeList = new ArrayList<Department>();
		String prefix = "┫";
		DepartmentUtil.tree(topDepartments, treeList, prefix, null);
		ActionContext.getContext().put("departments", treeList);
		
		//准备要显示的岗位数据
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		return "saveUI";
	}
	
	public String add() {
		//有id数组得到所有的岗位信息
		List<Role> roles = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roles));
		//判断是否为user选择部门
		if(model.getDepartment().getId() == -1) {
			model.setDepartment(null);
		}
		userService.add(model);
		return "toList";
	}
	
	public String editUI() {
		
		model = userService.getById(model.getId());
		//准备要回显的部门树状数据（不包含自己的部门以及自己部门的下属部门）
		List<Department> topDepartments = departmentService.findTopLevelDepartment();
		List<Department> treeList = new ArrayList<Department>();
		String prefix = "┫";
		DepartmentUtil.tree(topDepartments, treeList, prefix, null);
		ActionContext.getContext().put("departments", treeList);
		//准备要显示的岗位信息
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		
		return "saveUI";
	}
	
	public String edit() {
		//有id数组得到所有的岗位信息
		List<Role> roles = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roles));
		//判断是否为user选择部门
		if(model.getDepartment().getId() == -1) {
			model.setDepartment(null);
		}
		userService.updateExpectPassword(model);
		return "toList";
	}
	
	public String delete() {
		userService.delete(model);
		return "toList";
	}
	
	public String initPassword() {
		model = userService.getById(model.getId());
		userService.initPassword(model);
		return "toList";
	}


	public Integer[] getRoleIds() {
		return roleIds;
	}


	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}


	public Integer getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


}
