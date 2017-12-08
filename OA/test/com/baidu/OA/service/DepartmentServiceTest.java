package com.baidu.OA.service;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.Execution;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.OA.model.Application;
import com.baidu.OA.model.Department;
import com.baidu.OA.model.User;
import com.baidu.OA.service.DepartmentService;

@ContextConfiguration(locations = "classpath:beans.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class DepartmentServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	DepartmentService departmentService;
	//private ProcessEngine processEngine;

	@Test
	@Rollback(false)
	public final void test() {
		Department department = new Department();
		department.setName("a");
		department.setDescription("a");
		department.setId(1);

		departmentService.add(department);

		// departmentService.add(department);

		/*
		 * Department parent = new Department(); parent.setId(7);
		 */

		/*
		 * department.setParent(parent); List<Department> parents = new
		 * ArrayList<Department>(); departmentService.findParent(department,
		 * parents); for(Department parent1 : parents) {
		 * System.out.println(parent1.getName());
		 * System.out.println(parent1.getDescription()); }
		 */

		/*
		 * Department department =
		 * departmentService.getDepartmentDao().getById(7);
		 * System.out.println(department.getParent());
		 */

	}

	@Test
	public void treeTest() {
		List<Department> topLevelDepartments = departmentService
				.findTopLevelDepartment();
		List<Department> treeList = new ArrayList<Department>();
		treeDisplay(topLevelDepartments, "-|", treeList);
		for (Department department : treeList) {
			System.out.println(department.getName());
		}
	}

	public void treeDisplay(Collection<Department> topLevelDepartments,
			String prefix, List<Department> treeList) {
		for (Department department : topLevelDepartments) {
			Department dept = new Department();
			dept.setId(department.getId());
			dept.setName(prefix + department.getName());
			treeList.add(dept);
			treeDisplay(department.getChildren(), "   " + prefix, treeList);
		}

	}

	@Test
	@Rollback(false)
	public void testDeleteChildren() {
		Department department = new Department();
		department.setId(1);
		departmentService.deleteDepartmentAndChildren(department);
	}
	
	@Test
	public void test2() {
		/*
		Task task = processEngine.getTaskService().getTask("520010");
		Execution exe =  processEngine.getExecutionService().findExecutionById("TestJoinFork.520007.to task2.520009");
		ProcessInstance pi = (ProcessInstance) exe.getProcessInstance();
		System.out.println("exe:" + exe);
		System.out.println("pi:" + pi);*/
	}

	@Test
	public void test1() {
		// 设置流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		// ==========================
		Application app = new Application();
		User user = new User();
		user.setLoginName("张三");
		app.setApplicant(user);
		variables.put("application", app);
		//==========================
		
	/*	ProcessInstance pi = processEngine.getExecutionService()//
				.startProcessInstanceByKey("员工请假流程", variables);*/
		
	}
	
	@Test
	public void terst2() {
		try {
			write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		
	}

	 private static void write() throws IOException {
	        // 创建序列化流对象
	        // public ObjectOutputStream(OutputStream out)
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
	                "a.txt"));
	        // 创建对象
	        Application app = new Application();
			User user = new User();
			user.setLoginName("张三");
			app.setApplicant(user);
	        oos.writeObject(app);
	        // 释放资源
	        oos.close();
	    }
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	@Resource(name = "departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Resource(name = "processEngine")
	public void setProcessEngine(ProcessEngine processEngine) {
		/*this.processEngine = processEngine;*/
	}
}
