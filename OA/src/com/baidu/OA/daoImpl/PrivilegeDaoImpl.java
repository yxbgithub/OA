package com.baidu.OA.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.PrivilegeDao;
import com.baidu.OA.model.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

	@Override
	public List<Privilege> findTopPrivileges() {
		List<Privilege> topPrivileges= this.getHinernateTemplate().find("from t_privilege privilege where privilege.parent is null");
		return topPrivileges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllurls() {
		List<String> urls = (List<String>) this.getHinernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				return session.createQuery("select distinct p.url from t_privilege p where p.url is not null")//
						.list();
			}
		});
		return urls;
	}

}
