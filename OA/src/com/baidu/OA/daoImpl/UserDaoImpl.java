package com.baidu.OA.daoImpl;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
		entity.setPassword(md5);
		super.save(entity);
	}

	@Override
	public User getByLoginNameAndPassword(final String loginName, final String password) {
		User user = (User) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
			User user =	(User) session.createQuery("from t_user u where u.loginName = :loginName and u.password = :password")//
					.setParameter("loginName", loginName)//
					.setParameter("password", password)//
					.uniqueResult();
				return user;
			}
		});
		return user;
	}
}
