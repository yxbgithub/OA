package com.baidu.OA.util;

import java.util.Collection;
import java.util.List;

import com.baidu.OA.model.Department;

public class DepartmentUtil {
	
	public static boolean hasParent(Department department) {
		if(department == null) return false;
		if(department.getParent() == null) return false;
		return true;
	}
	
	/*public static void copyToList(Department department, List<Department> list, String prefix) {
		Department dept = new Department();
		dept.setId(department.getId());
		dept.setName(prefix + department.getName());
		list.add(dept);
	}*/

	public static void tree(Collection<Department> departments,
			List<Department> treeList, String prefix, Department removedDepartment) {
			for(Department department : departments) {
				if(removedDepartment != null && (removedDepartment.getId() ==department.getId())) {
					continue;
				}
				Department copy = new Department();
				copy.setId(department.getId());
				copy.setName(prefix + department.getName());
				treeList.add(copy);
				tree(department.getChildren(), treeList, "　" + prefix, removedDepartment);
			}
		
	}
}
