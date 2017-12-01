package com.baidu.jbpm_and_spring_integration;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = "classpath:beans.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestJbpm extends AbstractTransactionalJUnit4SpringContextTests {
	ProcessEngine processEngine;

	@Test
	public final void testDeploment() {
		// 部署（添加）:就是创建表并将我们创建的xxx.jpdl.xml、xxx.png持久化到数据库
				String deploymentId = processEngine.getRepositoryService()//
						.createDeployment()// 创建部署对象
						.addResourceFromClasspath("jbpm/jbpm.jpdl.xml")// 添加一个要部署的文件
						.addResourceFromClasspath("jbpm/jbpm.png")// 添加一个要部署的文件
						.deploy();// 执行部署操作

				/*
				 * ZipInputStream in = new ZipInputStream(new
				 * FileInputStream("xxxxx.zip"));
				 * 
				 * String deploymentId = processEngine.getRepositoryService()//
				 * .createDeployment()// .addResourcesFromZipInputStream(in)//
				 * .deploy();
				 */
	}


	@Resource(name="processEngine")
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

}
