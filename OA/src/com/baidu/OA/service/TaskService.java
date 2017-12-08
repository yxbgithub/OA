package com.baidu.OA.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import com.baidu.OA.model.Application;
import com.baidu.OA.model.ApproveInfo;
import com.baidu.OA.model.User;
import com.baidu.OA.util.TaskView;

@Service("taskService")
public class TaskService {
	private ProcessEngine processEngine;

	@Resource(name = "processEngine")
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	public List<TaskView> getTaskView(User user) {
		// 所有的申请信息已经在提交申请的时候和流程实例绑定，所以先查出当前用户的所有任务
		String userId = user.getLoginName();// userId就是用户的登陆名
		List<TaskView> taskViews = new ArrayList<TaskView>();

		List<Task> tasks = (List<Task>) processEngine.getTaskService()//
				.findPersonalTasks(userId);
		for (Task task : tasks) {
			Application application = (Application) processEngine
					.getTaskService().getVariable(task.getId(), "application");
			// 创建一个taskview对象，并将其加入list
			TaskView taskView = new TaskView(task, application);
			taskViews.add(taskView);
		}
		return taskViews;
	}

	public void approve(String taskId, ApproveInfo approveInfo, String outcome) {
		// 查询任务，一定要在办理任务之前查询
		Task task = processEngine.getTaskService().getTask(taskId);
		if (null == outcome)// 如果没有指定离开路线，那么采用默认的离开路线 办理任务
			processEngine.getTaskService().completeTask(taskId);
		else
			// 否则使用指定的离开路线离开
			processEngine.getTaskService().completeTask(taskId, outcome);

		ProcessInstance pi = processEngine.getExecutionService()//
				.findProcessInstanceById(task.getExecutionId());
		// 如果不同意，
		if (!approveInfo.isApproval()) {
			// 直接结束流程，
			processEngine.getExecutionService().endProcessInstance(pi.getId(),
					ProcessInstance.STATE_ENDED);
			// 将application的状态设置为“未通过”
			approveInfo.getApplication().setStatus(Application.STATUS_REJECTED);
		} else {
			// 如果当前任务是最后一个任务，将application状态设置为“已通过”
			if (null == pi) {
				approveInfo.getApplication().setStatus(
						Application.STATUS_RAPPROVED);
			}
		}

	}

	public List<String> getOutcomesByTaskId(String taskId) {
		return new ArrayList<String>(processEngine.getTaskService()
				.getOutcomes(taskId));
	}
}
