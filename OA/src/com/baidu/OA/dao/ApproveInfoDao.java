package com.baidu.OA.dao;

import java.util.List;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.ApproveInfo;
import com.baidu.OA.util.QueryHelper;

public interface ApproveInfoDao extends BaseDao<ApproveInfo> {

	List<ApproveInfo> approvedHistory(QueryHelper queryHelper);

}
