package com.baidu.OA.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_application")
public class Application implements Serializable {
	private static final long serialVersionUID = -3263797264089676260L;
	//申请状态常量
	public static final String STATUS_RUNNING = "流转中";
	public static final String STATUS_RAPPROVED = "已通过";
	public static final String STATUS_REJECTED = "未通过";
	
	private int id;
	private String title;//申请的标题
	private String path;//文档的存储路径
	private String status;//申请的状态
	private Date applyTime;//申请时间
	
	private User applicant;//申请人
	private Template template;//申请使用的模板
	private Set<ApproveInfo> approveInfos;//审批信息

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne
	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	@Column(columnDefinition="timestamp")
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@ManyToOne
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@OneToMany(mappedBy="application")
	public Set<ApproveInfo> getApproveInfos() {
		return approveInfos;
	}

	public void setApproveInfos(Set<ApproveInfo> approveInfos) {
		this.approveInfos = approveInfos;
	}

}
