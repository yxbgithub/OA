package com.baidu.OA.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_approveInfo")
public class ApproveInfo{
	//意见常量
	public static final boolean APPROVED = true;//同意
	public static final boolean REJECTED = false;//不同意
	
	private int id;
	private String comment;//审批意见
	private boolean approval;//是否同意
	private Date approveTime;//审批时间
	
	private User approver;//审批人
	private Application application;//审批所关联的申请

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="c_comment")
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

	@Column(columnDefinition="timestamp")
	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	@ManyToOne
	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}

	@ManyToOne
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
