package com.baidu.OA.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.baidu.OA.model.User;

public class ModelUtilTest {

	@Test
	public final void testTableName() {
		System.out.println(ModelUtil.getTableName(User.class));
	}

}
