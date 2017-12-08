package com.baidu.OA.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.User;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ModelDrivenAction<User> {
	
	public String loginInUI() {
		return "loginInUI";
	}
	
	
	public String loginIn() {
		User user  = userService.getByLoginNameAndPassword(model.getLoginName(), model.getPassword());
		if(null == user) {
			this.addFieldError(ERROR, "用户名或密码错误");
			return "loginInUI";
		}
		ActionContext.getContext().getSession().put("user", user);
		return "toIndex";
	}
	
	
	public String loginOut() {
		ActionContext.getContext().getSession().remove("user");
		return "loginOutUI";
	}
}
