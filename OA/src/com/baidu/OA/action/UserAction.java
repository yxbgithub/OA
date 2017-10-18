package com.baidu.OA.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{
	private  UserService userService;
	
	@Override
	public String execute() throws Exception {
System.out.println("-------------->userService" + userService);
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
