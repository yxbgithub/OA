package com.baidu.OA.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.baidu.OA.model.Privilege;
import com.baidu.OA.service.PrivilegeService;

public class OAListener implements ServletContextListener {
	private Logger logger = LoggerFactory.getLogger(OAListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//从event中获取servletContext对象
		ServletContext application = sce.getServletContext();
		//通过spring为我们提供的工具类罗去servletContext里面的applicationContext属性
		ApplicationContext factory = WebApplicationContextUtils.getWebApplicationContext(application);
		//取出顶级权限
		PrivilegeService privilegeService = (PrivilegeService) factory.getBean("privilegeService");
		List<Privilege> topPrivileges = privilegeService.findTopPrivileges();
		//将顶级权限放入application中，以备后面使用
		application.setAttribute("topPrivileges", topPrivileges);
System.out.println("------------------------已经将topPrivileges放入application中----------------------");
		logger.info("------------------------已经将topPrivileges放入application中----------------------");
		//将所有权限的url放入list当中加入application（去掉权限url为null为重复的）
		List<String> privilegeUrls = privilegeService.findAllUrls();
		application.setAttribute("privilegeUrls", privilegeUrls);
		logger.info("------------------------已经将privilegeUrls放入application中----------------------");
System.out.println("------------------------已经将privilegeUrls放入application中----------------------");		
	}

}
