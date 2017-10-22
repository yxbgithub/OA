package com.baidu.OA.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.baidu.OA.model.Role;
import com.baidu.OA.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role>{
	private RoleService roleService;
	private Role role = new Role();
	
	public String list() {
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		return "list";
	}

	
	public String editUI() {
		/*String name = roleService.getRoleById(role.getId()).getName();
		String description = roleService.getRoleById(role.getId()).getDescription();
		role.setName(name);
		role.setDescription(description);*/
		role = roleService.getById(role.getId());
System.out.println(role.getName());
		ActionContext.getContext().put("role", role);
		return "editUI";
	}
	
	
	public String addUI() {
		return "addUI";
	}
	
	public String edit() {
		roleService.edit(role);
		return "toList";
	}
	
	public String add() {
		roleService.add(role);
		return "toList";
	}
	
	public RoleService getRoleService() {
		return roleService;
	}
	
	public String delete() {
		roleService.delete(role);
		return "toList";
	}
	
	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


	@Override
	public Role getModel() {
		return role;
	}


}
