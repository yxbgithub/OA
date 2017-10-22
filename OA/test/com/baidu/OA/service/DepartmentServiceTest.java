package com.baidu.OA.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.OA.model.Department;

@ContextConfiguration(locations="classpath:beans.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)
public class DepartmentServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	DepartmentService departmentService;
	
	
	@Test
	@Rollback(false)
	public final void test() {
		Department department = new Department();
		department.setName("d");
		department.setDescription("d");
		
		Department parent = new Department();
		parent.setId(7);
		
		department.setParent(parent);
		List<Department> parents = new ArrayList<Department>();
		departmentService.findParent(department, parents);
		for(Department parent1 : parents) {
			System.out.println(parent1.getName());
			System.out.println(parent1.getDescription());
		}
		
	/*	Department department = departmentService.getDepartmentDao().getById(7);
		System.out.println(department.getParent());*/
		
		
	}


	public DepartmentService getDepartmentService() {
		return departmentService;
	}


	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
