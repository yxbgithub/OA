package com.baidu.OA.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findChilaren(final int parentId) {
		List<Department> children = null;
		children = (List<Department>) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from t_department t_dept where t_dept.parent.id = :parentId");
				query.setInteger("parentId", parentId);
				return query.list();
			}
		});
		
		return children;
	}

	@Override
	public List<Department> findTopLevelDepartment() {
		
		return (List<Department>)this.getHinernateTemplate().find("from t_department t_dept where t_dept.parent = null");
	}

}
