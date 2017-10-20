package com.baidu.OA.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.User;

public interface UserDao extends BaseDao<User>{
	HibernateTemplate getTemplate();
}
