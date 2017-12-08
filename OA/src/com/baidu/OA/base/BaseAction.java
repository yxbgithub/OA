package com.baidu.OA.base;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.baidu.OA.model.User;
import com.baidu.OA.service.ApplicationService;
import com.baidu.OA.service.ApproveInfoService;
import com.baidu.OA.service.DepartmentService;
import com.baidu.OA.service.ForumService;
import com.baidu.OA.service.PrivilegeService;
import com.baidu.OA.service.ProcessDefinationService;
import com.baidu.OA.service.ReplyService;
import com.baidu.OA.service.RoleService;
import com.baidu.OA.service.TaskService;
import com.baidu.OA.service.TemplateService;
import com.baidu.OA.service.TopicService;
import com.baidu.OA.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 给Action提供service实例和一些公共的方法
 * @author jack
 *
 */
public class BaseAction extends ActionSupport {
	protected RoleService roleService;
	protected DepartmentService departmentService;
	protected UserService userService;
	protected PrivilegeService privilegeService;
	protected ForumService forumService;
	protected TopicService topicService;
	protected ReplyService replyService;
	protected ProcessDefinationService processDefinationService;
	protected TemplateService templateService;
	protected ApplicationService applicationService;
	protected TaskService taskService;
	protected ApproveInfoService approveInfoService;

	protected int currentPage = 1;

	@Resource(name="processDefinationService")
	public void setProcessDefinationService(
			ProcessDefinationService processDefinationService) {
		this.processDefinationService = processDefinationService;
	}
	
	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Resource(name = "departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource(name = "privilegeService")
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	@Resource(name = "forumService")
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@Resource(name = "topicService")
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	@Resource(name = "replyService")
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Resource(name="templateService")
	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}
	
	@Resource(name="applicationService")
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Resource(name="taskService")
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@Resource(name="approveInfoService")
	public void setApproveInfoService(ApproveInfoService approveInfoService) {
		this.approveInfoService = approveInfoService;
	}

	// ==================工具方法====================
	public String getRequestIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	public User getUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
