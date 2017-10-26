package com.baidu.OA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.DepartmentDao;
import com.baidu.OA.model.Department;
import com.baidu.OA.util.DepartmentUtil;

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
		if(-1 == department.getParent().getId()) {
			department.setParent(null);
		}
		departmentDao.save(department);
	}


	public void delete(Department department) {
		departmentDao.delete(department.getId());
	}
	
	public void findParent(Department department, List<Department> parents) {
		departmentDao.findParent(department, parents);
	}

	public void update(Department department) {
		if(-1 == department.getParent().getId()) {
			department.setParent(null);
		}
		departmentDao.update(department);
	}

	public void deleteDepartmentAndChildren(Department department) {
		List<Department> children = departmentDao.findChilaren(department.getId());
		for(int i=0; i<children.size(); i++) {
			deleteDepartmentAndChildren(children.get(i));
		}
		departmentDao.delete(department.getId());
		
	}

	public List<Department> findTopLevelDepartment() {
		return departmentDao.findTopLevelDepartment();
	}


	public List<Department> finChildren(int parentId) {
		return departmentDao.findChilaren(parentId);
	}


	public Department getById(int id) {
		return departmentDao.getById(id);
	}
}
