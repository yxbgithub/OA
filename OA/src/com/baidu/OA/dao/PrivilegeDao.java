package com.baidu.OA.dao;

import java.util.List;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {

	public List<Privilege> findTopPrivileges();

	public List<String> findAllurls();

	

}
