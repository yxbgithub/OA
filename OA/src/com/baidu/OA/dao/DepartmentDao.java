package com.baidu.OA.dao;

import java.util.List;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Department;

public interface DepartmentDao extends BaseDao<Department>{

	public void findParent(Department department, List<Department> parents );
}
