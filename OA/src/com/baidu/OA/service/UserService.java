package com.baidu.OA.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
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

	public void update(User model) {
		userDao.update(model);
	}

	public User getById(int id) {
		return userDao.getById(id);
	}

	public void initPassword(User model) {
		String md5 = DigestUtils.md5Hex("1234");
		model.setPassword(md5);
		this.update(model);
	}

	public void updateExpectPassword(User model) {
		//因为user是才从数据库里面取出来的对象，还在session里面，当我们对一级缓存里面的对象进行更改的时候，
		//后来update的时候只更新更改过的属性
		User user = userDao.getById(model.getId());
		user.setDepartment(model.getDepartment());
		user.setDescription(model.getDescription());
		user.setEmail(model.getEmail());
		user.setGender(model.getGender());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setRoles(model.getRoles());
		userDao.update(user);
		
	}


}
