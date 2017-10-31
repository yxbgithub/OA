package com.baidu.OA.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("homeAction")
@Scope("prototype")
public class HomeAction extends ActionSupport {
	
	public String index() {
		/*if(null == ActionContext.getContext().getSession().get("user")) {
			return "toLoginInUI";
		}*/
		
		return "index";
	}
	
	public String left() {
		
		return "left";
	}
	
	public String right() {
		return "right";
	}
	
	public String top() {
		return "top";
	}
	
	public String bottom() {
		return "bottom";
	}
}

