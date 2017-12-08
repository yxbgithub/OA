package com.baidu.OA.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.BaseAction;
import com.baidu.OA.model.Application;
import com.baidu.OA.model.ApproveInfo;
import com.baidu.OA.service.ApplicationService;
import com.baidu.OA.util.TaskView;
import com.opensymphony.xwork2.ActionContext;

@Controller("taskAction")
@Scope("prototype")
public class TaskAction extends BaseAction {
	private String taskId;//因为task的id在数据库中是String类型（可能带有汉字）
	private Integer applicationId;
	private String comment;
	private boolean approval;//true为同意
	private String outcome;//指定离开活动的路线transition
	
	public String myTasks() {
		//准备数据
		List<TaskView> taskView = taskService.getTaskView(getUser());
		//将数据入栈
		ActionContext.getContext().put("taskView", taskView);
		return "myTasks";
	}
	
	public String approveUI() {
		List<String> outcomes = taskService.getOutcomesByTaskId(taskId);
		ActionContext.getContext().put("outcomes", outcomes);
		return "approveUI";
	}
	
	public String approve() {
		//准备数据
		ApproveInfo approveInfo = new ApproveInfo();
		//设置相应的属性
		approveInfo.setApplication(applicationService.getById(applicationId));
		approveInfo.setApproval(approval);
		approveInfo.setApprover(getUser());
		approveInfo.setComment(comment);
		approveInfo.setApproveTime(new Date());
		//持久化审批信息
		approveInfoService.save(approveInfo);
		
		taskService.approve(taskId,approveInfo,outcome);
		
		return "toMyTasks";
	}
//=================================================
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
}
