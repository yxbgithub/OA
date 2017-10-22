package com.baidu.OA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.DepartmentDao;
import com.baidu.OA.model.Department;

@Service("departmentService")
public class DepartmentService {
	private DepartmentDao departmentDao;

	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	@Resource(name="departmentDaoImpl")
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void add(Department department) {
		departmentDao.save(department);
	}


	public void delete(Department department) {
		departmentDao.delete(department.getId());
	}
	
	public void findParent(Department department, List<Department> parents) {
		departmentDao.findParent(department, parents);
	}

	public void update(Department department) {
		departmentDao.update(department);
	}

}
