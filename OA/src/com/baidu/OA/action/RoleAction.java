package com.baidu.OA.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.baidu.OA.model.Role;
import com.baidu.OA.base.BaseAction;
import com.baidu.OA.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
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
	
	
	
	public String delete() {
		model = roleService.getById(model.getId());
		roleService.delete(model);
		return "toList";
	}
}
