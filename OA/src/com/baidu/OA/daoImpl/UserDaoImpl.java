package com.baidu.OA.daoImpl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.UserDao;
import com.baidu.OA.model.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public HibernateTemplate getTemplate() {
		return super.getHinernateTemplate();
	}
	
	
}
