package com.baidu.OA.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import com.baidu.OA.dao.ApplicationDao;
import com.baidu.OA.model.Application;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.PageBean;
import com.baidu.OA.model.Topic;
import com.baidu.OA.model.User;
import com.baidu.OA.util.Configuration;
import com.baidu.OA.util.QueryHelper;

@Service("applicationService")
public class ApplicationService {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");
	private ApplicationDao applicationDao;
	private ProcessEngine processEngine;

	public void submit(Application application, File upload) {
		// 设置相应属性
		application.setStatus(Application.STATUS_RUNNING);// 设置申请状态，默认为“审批中”
		application.setPath(saveUpload(upload));// 设置填写的模板地址属性
		application.setApplyTime(new Date());// 设置“申请时间”属性
		application.setTitle(application.getTemplate().getName() + "_"
				+ application.getApplicant().getName() + "_"
				+ simpleDateFormat.format(new Date()));// 标题格式：{模版名称}_{申请人姓名}_{申请日期}

		// 持久化application
		applicationDao.save(application);
		// 设置流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("application", application);
		// 启动流程实例
		String processKey = application.getTemplate().getDefinationName();
		ProcessInstance pi = processEngine.getExecutionService()//
				.startProcessInstanceByKey(processKey, variables);
		// 办理第一个任务--提交申请
		Task task = processEngine.getTaskService()//
				.createTaskQuery()// 查询出本流程实例中当前情况下仅有的一个任务
				.processInstanceId(pi.getId())//
				.uniqueResult();
		processEngine.getTaskService().completeTask(task.getId());// 办理任务
	}

	public String saveUpload(File upload) {
		String path = null;
		if (upload != null) {
			SimpleDateFormat format = new SimpleDateFormat("/yyyy-MM-dd/");
			String basePath = ServletActionContext.getServletContext()
					.getRealPath("/WEB-INF/jsp/downloadFiles");
			// 格式化 日期，以便用来作为文件夹的名称
			String datePath = format.format(new Date());
			path = basePath + datePath;
			File dir = new File(path);
			// 如果所指目录不存在的话，就穿件目录文件夹
			if (!dir.exists()) {
				// 使用mkdirs函数，如果父路径不存在的话也一并创建
				dir.mkdirs();
			}
			// 最后加的uuid是文件的名字，在做rename操作的时候，路径的最后一项就是剪切后文件的名称
			path = path + UUID.randomUUID();
			// 剪切文件
			upload.renameTo(new File(path));
		}
		return path;
	}

	@Resource(name = "applicationDao")
	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

	@Resource(name = "processEngine")
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	public PageBean getPageBean(int currentPage, QueryHelper queryHelper) {
		return applicationDao.getRecordList(queryHelper, currentPage);
	}

	public Application getById(Integer applicationId) {
		Application application = null;
		if(null!=applicationId) {
			application = applicationDao.getById(applicationId);
		}
		return application;
	}

}
