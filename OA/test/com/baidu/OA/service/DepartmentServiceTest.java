package com.baidu.OA.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.OA.model.Department;
import com.baidu.OA.service.DepartmentService;

@ContextConfiguration(locations="classpath:beans.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
public class DepartmentServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	DepartmentService departmentService;
	
	
	@Test
	@Rollback(false)
	public final void test() {
		Department department = new Department();
		department.setName("a");
		department.setDescription("a");
		department.setId(1);
		
		//departmentService.add(department);
		
		/*Department parent = new Department();
		parent.setId(7);*/
		
		/*department.setParent(parent);
		List<Department> parents = new ArrayList<Department>();
		departmentService.findParent(department, parents);
		for(Department parent1 : parents) {
			System.out.println(parent1.getName());
			System.out.println(parent1.getDescription());
		}*/
		
	/*	Department department = departmentService.getDepartmentDao().getById(7);
		System.out.println(department.getParent());*/
		
		
	}

	@Test
	public void treeTest() {
		List<Department> topLevelDepartments = departmentService.findTopLevelDepartment();
		List<Department> treeList = new ArrayList<Department>();
		treeDisplay(topLevelDepartments,"-|", treeList);
		for(Department department : treeList) {
			System.out.println(department.getName());
		}
	}
	
	
	public void treeDisplay(Collection<Department> topLevelDepartments, String prefix, List<Department> treeList) {
		for(Department department : topLevelDepartments) {
			Department dept = new Department();
			dept.setId(department.getId());
			dept.setName(prefix + department.getName());
			treeList.add(dept);
			treeDisplay(department.getChildren(),"   " + prefix, treeList);
		}
		
	}
	
	
	@Test
	@Rollback(false) 
	public void testDeleteChildren() {
		Department department = new Department();
		department.setId(1);
		departmentService.deleteDepartmentAndChildren(department);
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}


	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
