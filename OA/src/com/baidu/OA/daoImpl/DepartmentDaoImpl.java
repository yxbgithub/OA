package com.baidu.OA.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.DepartmentDao;
import com.baidu.OA.model.Department;
import com.baidu.OA.util.DepartmentUtil;

@Repository("departmentDaoImpl")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

	@Override
	public void findParent(Department department, List<Department> parents ) {
		if(DepartmentUtil.hasParent(department)) {
			int parentId = department.getParent().getId();
			Department parent = this.getById(parentId);
			parents.add(parent);
			findParent(parent,parents);
			
		}
	}

	
	
	
}
