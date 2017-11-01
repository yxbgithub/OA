package com.baidu.OA.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baidu.OA.daoImpl.DepartmentDaoImpl;
import com.baidu.OA.daoImpl.UserDaoImpl;
import com.baidu.OA.model.Department;

public class DepartmentDaoImplTest {

	//测试BaseDaoImpl的构造方法是否能正常拿到泛型
	@Test
	public final void test() {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		DepartmentDao departmentDao = (DepartmentDaoImpl)factory.getBean("departmentDaoImpl");
		SessionFactory sf = (SessionFactory)factory.getBean("sessionFactory");
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Department department = new Department();
		department = (Department)session.get(Department.class, 61);
		/*department.setId(1);
		department.setName("d");
		department.setDescription("d");
		session.save(department);*/
		//session.flush();
		/*department.setName("e");
		department.setDescription("e");*/
		//session.getTransaction().commit();
		//departmentDao.save(department);
		department.setName("aa");
		department.setDescription("aa");
		session.getTransaction().commit();
		System.out.println(department.getId());
		
	}
	
	@Test
	public final void test1() {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		
	}
}