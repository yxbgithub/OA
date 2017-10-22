package com.baidu.OA.util;

import com.baidu.OA.model.Department;

public class DepartmentUtil {
	
	public static boolean hasParent(Department department) {
		if(department == null) return false;
		if(department.getParent() == null) return false;
		return true;
	}
}
