package com.baidu.OA.daoImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.UserDao;
import com.baidu.OA.model.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public void save(User entity) {
		String md5 = DigestUtils.md5Hex("1234");
		entity.setPassword("md5");
		super.save(entity);
	}
}
