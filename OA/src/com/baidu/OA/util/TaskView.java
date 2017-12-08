package com.baidu.OA.util;

import org.jbpm.api.task.Task;

import com.baidu.OA.model.Application;

/**
 * 将task和application封装，便于在“待我审批”页面做循环展示
 * 
 * @author jack
 * 
 */
public class TaskView {
	private Task task;
	private Application application;

	public TaskView(Task task, Application application) {
		this.task = task;
		this.application = application;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
