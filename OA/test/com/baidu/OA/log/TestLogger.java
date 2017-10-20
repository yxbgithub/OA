package com.baidu.OA.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.Entity;

import org.junit.Test;

import com.baidu.OA.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class TestLogger extends Superclass<String>{
	private String name = "subclass";
	
	//用common-logging接口编程
	//private org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(TestLogger.class);
	
	//用slf4j的接口编程
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestLogger.class);
	
	@Test
	public final void test() {
		log.debug("这是debug级别");
		log.info("这是info级别");
		log.warn("这是警告信息");
		log.error("这是错误信息");
	}
	
	@Test
	public final void test1() {
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
		java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		for(Type type : actualTypeArguments) {
			System.out.println(type);
		}
		
	}
	
	@Test
	public final void test2() {
		new TestLogger().print();
		
	}

}
