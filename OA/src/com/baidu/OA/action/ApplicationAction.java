package com.baidu.OA.action;

import java.io.File;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.Application;
import com.baidu.OA.model.ApproveInfo;
import com.baidu.OA.model.PageBean;
import com.baidu.OA.model.Template;
import com.baidu.OA.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@Controller("applicationAction")
@Scope("prototype")
public class ApplicationAction extends ModelDrivenAction<Application> {
	private static final long serialVersionUID = -3553707110402766027L;
	private File upload;
	private Integer templateId;
	
	// 申请模板列表o
	public String templateList() {
		// 查询所有的模板
		List<Template> tpList = templateService.findAllTemplate();
		// 将模板放入值栈中
		ActionContext.getContext().put("tpList", tpList);
		return "templateList";
	}

	// 提交模板的界面么
	public String submitUI() {
		//准备数据（所有的离开路线）
		return "submitUI";
	}

	// 提交模板处理
	public String submit() {
		// 从数据库中取出一个
		Template template = templateService.getById(templateId);
		// new一个Application，给其设置属性
		Application application = new Application();
		// 设置响相应的属性
		application.setApplicant(getUser());// 设置"申请人"属性
		application.setTemplate(template);// 设置"模板"属性
		applicationService.submit(application, upload);

		return "toMyApplicationList";
	}

	// 我的申请查询
	public String myApplicationList() {
		//准备分页需要显示的信息
		QueryHelper queryHelper = new QueryHelper(Application.class, "app")//
				.addWhereCondition("app.applicant =?", getUser())//
				.addWhereCondition((null != templateId), "app.template.id =?",
						templateId)// 按照模板的类别查询
				.addWhereCondition(
						(Application.STATUS_RAPPROVED.equals(model.getStatus())),
						"app.status =?", Application.STATUS_RAPPROVED)//
				.addWhereCondition(
						(Application.STATUS_REJECTED.equals(model.getStatus())),
						"app.status =?", Application.STATUS_REJECTED)//
				.addWhereCondition(
						(Application.STATUS_RUNNING.equals(model.getStatus())),
						"app.status =?", Application.STATUS_RUNNING)//
				.orderByClause("app.applyTime", false);// 按照申请时间降序排列
		PageBean pageBean = applicationService.getPageBean(currentPage,queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//准备要显示的模板信息
		List<Template> tpList = templateService.findAllTemplate();
		ActionContext.getContext().put("tpList", tpList);
		return "myApplicationList";
	}

	// 查看申请信息
	public String applicationInfo() {
		return "applicationInfo";
	}

	// 查看流转记录
	public String approvedHistory() {
		//拼接查询语句
		QueryHelper queryHelper = new QueryHelper(ApproveInfo.class,"appInfo")//
			.addWhereCondition("appInfo.application.id =?", model.getId())//
			.orderByClause("appInfo.approveTime", true);//按照审批时间升序排列
		//准备数据
		List<ApproveInfo> approInfos = approveInfoService.approvedHistory(queryHelper);
		ActionContext.getContext().put("approInfos", approInfos);
		return "approvedHistory";
	}

	// ===============================================

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
}
