package com.baidu.OA.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.UserDao;
import com.baidu.OA.model.User;

@Service("userService")
public class UserService {
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(new User());
		//int i = 9/0;
		userDao.save(new User());
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
