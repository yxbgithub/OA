package com.baidu.OA.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.model.Department;
import com.baidu.OA.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	private DepartmentService departmentService;
	private Department department = new Department();
	
	public String list() {
		List<Department> departments =null;
		departments = departmentService.findAll();
		ActionContext.getContext().put("departments", departments);
		return "list";
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	
	public String addUI() {
		List<Department> departments =null;
		departments = departmentService.findAll();
		ActionContext.getContext().put("departments", departments);
System.out.println("-------------------------->aaaaa");
		return "addUI";
	}
	
	public String add() {
System.out.println("------------------------------>bbbbb");
System.out.println("id:" + department.getId());
//System.out.println("id:" + department.getId() + "parentId:" + department.getParent().getId());
		departmentService.add(department);

		return "toList";
	}

	public String delete() {
		departmentService.delete(department);
		return "toList";
	}
	
	public String editUI() {
		List<Department> parents = new ArrayList<Department>();
		departmentService.findParent(department, parents);
		ActionContext.getContext().put("parents", parents);
		return "editUI";
	}
	
	public String edit() {
		departmentService.update(department);
		return "toList";
	}
	
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Department getModel() {
		return department;
	}

	
	
}
