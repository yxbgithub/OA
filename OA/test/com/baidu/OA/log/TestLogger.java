package com.baidu.OA.log;

import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class TestLogger {
	
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

}
