package com.baidu.OA.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.baidu.OA.daoImpl.UserDaoImpl;

public class UserDaoImplTest {

	//测试BaseDaoImpl的构造方法是否能正常拿到泛型
	@Test
	public final void test() {
		UserDao userDao = new UserDaoImpl();
	}

}