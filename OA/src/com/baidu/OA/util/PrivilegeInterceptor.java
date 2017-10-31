package com.baidu.OA.util;

import com.baidu.OA.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivilegeInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//准备用户数据
		User user = (User) ActionContext.getContext().getSession().get("user");
		//准备用户访问的权限url地址
		String privilegUrl = invocation.getProxy().getActionName();
		//1、如果用户没有登录
		if(null == user) {
		//a、如果用户访问的是登录页面，则放行
			if(privilegUrl.startsWith("login_loginIn")) {
				return invocation.invoke();
			} else {
		//b、如果用户访问的不是登录页面，返回登录页面
				return "loginInUI";
			}
			
		}
		//2、如果用户已经登录
		//a、如果用户有权限访问，则放行
		if(user.hasPrivilegeByUrl(privilegUrl)) {
			return invocation.invoke();
		}
		//b、如果用户没有权限访问，则转到没有权限提示页面
		return "noPrivilege";
		
	}

}
