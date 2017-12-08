package com.baidu.OA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.ApproveInfoDao;
import com.baidu.OA.model.ApproveInfo;
import com.baidu.OA.util.QueryHelper;

@Service("approveInfoService")
public class ApproveInfoService {
	private ApproveInfoDao approveInfoDao;

	public void save(ApproveInfo approveInfo) {
		approveInfoDao.save(approveInfo);
	}

	@Resource(name = "approveInfoDao")
	public void setApproveInfoDao(ApproveInfoDao approveInfoDao) {
		this.approveInfoDao = approveInfoDao;
	}

	public List<ApproveInfo> approvedHistory(QueryHelper queryHelper) {
		return approveInfoDao.approvedHistory(queryHelper);
	}

}
