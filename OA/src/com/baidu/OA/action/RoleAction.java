package com.baidu.OA.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.model.Privilege;
import com.baidu.OA.model.Role;
import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends ModelDrivenAction<Role>{
	private Integer[] privilegeIds;
	
	public String list() {
		List<Role> roles =  roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		return "list";
	}

	
	public String editUI() {
		model = roleService.getById(model.getId());
		ActionContext.getContext().put("role", model);
		return "saveUI";
	}
	
	
	public String addUI() {
		return "saveUI";
	}
	
	public String edit() {
		roleService.edit(model);
		return "toList";
	}
	
	public String add() {
		roleService.add(model);
		return "toList";
	}
	
	
	public String setPrivilegeUI() {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().put("role", role);
		//准备要显示的权限数据（以树状结构展示）
		List<Privilege> privileges = null;
		privileges = privilegeService.findTopPrivileges();
		ActionContext.getContext().put("topPrivileges", privileges);
		return "setPrivilegeUI";
	}
	
	public String setPrivilege() {
		//根据传过来的role的id数据确定对哪个role设置权限
		Role role = roleService.getById(model.getId());
		//根据传过来的权限的id（多个、一个或者没有），从数据库中拿出权限对象
		List<Privilege> privileges = null;
		privileges = privilegeService.getByIds(privilegeIds);
		//将权限对象对应的Set加入role对象的属性中
		role.setPrivileges(new HashSet(privileges));
		roleService.update(role);
		return "toList";
	}
	
	public String delete() {
		model = roleService.getById(model.getId());
		roleService.delete(model);
		return "toList";
	}


	public Integer[] getPrivilegeIds() {
		return privilegeIds;
	}


	public void setPrivilegeIds(Integer[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}


	
}
