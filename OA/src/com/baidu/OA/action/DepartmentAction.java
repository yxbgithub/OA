package com.baidu.OA.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.BaseAction;
import com.baidu.OA.model.Department;
import com.baidu.OA.service.DepartmentService;
import com.baidu.OA.util.DepartmentUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	private Integer parentId;
	
	public String list() {
		List<Department> topDepartments =null;
		if(null == parentId) {
			topDepartments = departmentService.findTopLevelDepartment();
			ActionContext.getContext().put("departments", topDepartments);
		} else {
			List<Department> secondLevelDepartments =null;
			secondLevelDepartments = departmentService.finChildren(parentId.intValue());
			ActionContext.getContext().put("departments", secondLevelDepartments);
		}
		return "list";
	}
	
	public String addUI() {
		List<Department> topDepartments = departmentService.findTopLevelDepartment();
		List<Department> treeList = new ArrayList<Department>();
		String prefix = "┫";
		DepartmentUtil.tree(topDepartments, treeList, prefix, null);
		ActionContext.getContext().put("departments", treeList);
		return "saveUI";
	}
	
	public String add() {
		departmentService.add(model);
			return "toList";
	}

	public String delete() {
		departmentService.deleteDepartmentAndChildren(model);
		return "toList";
	}
	
	public String editUI() {
		List<Department> topDepartments = departmentService.findTopLevelDepartment();
		List<Department> treeList = new ArrayList<Department>();
		String prefix = "┫";
		DepartmentUtil.tree(topDepartments, treeList, prefix, model);
		ActionContext.getContext().put("departments", treeList);
		return "saveUI";
	}
	
	public String edit() {
		
		departmentService.update(model);
		return "toList";
	}
	
	public String back() {
		Department department = departmentService.getById(parentId.intValue());
		if(department.getParent() != null) {
			parentId = department.getParent().getId();
		} else {
			parentId = null;
		}
		return "toList";
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
