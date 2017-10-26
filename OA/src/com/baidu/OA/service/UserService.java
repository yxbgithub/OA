package com.baidu.OA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.UserDao;
import com.baidu.OA.model.User;

@Service("userService")
public class UserService {
	private UserDao userDao;
	
	public void add(User user) {
		userDao.save(user);
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}

	public void delete(User user) {
		userDao.delete(user.getId());
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
