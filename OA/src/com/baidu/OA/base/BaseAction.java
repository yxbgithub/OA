package com.baidu.OA.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.baidu.OA.model.User;
import com.baidu.OA.service.DepartmentService;
import com.baidu.OA.service.ForumService;
import com.baidu.OA.service.PrivilegeService;
import com.baidu.OA.service.ReplyService;
import com.baidu.OA.service.RoleService;
import com.baidu.OA.service.TopicService;
import com.baidu.OA.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	protected RoleService roleService;
	protected DepartmentService departmentService;
	protected UserService userService;
	protected PrivilegeService privilegeService;
	protected ForumService forumService;
	protected TopicService topicService;
	protected ReplyService replyService;
	
	
	protected T model;

	public BaseAction() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			 model = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		return model;
	}
	
	
	public RoleService getRoleService() {
		return roleService;
	}
	
	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}

	@Resource(name="privilegeService")
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public ForumService getForumService() {
		return forumService;
	}
	
	@Resource(name="forumService")
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	@Resource(name="topicService")
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	@Resource(name="replyService")
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	//==================工具方法====================
	public String getRequestIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	public User getUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
}

