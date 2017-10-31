package com.baidu.OA.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.PrivilegeDao;
import com.baidu.OA.model.Privilege;

@Service("privilegeService")
public class PrivilegeService {
	PrivilegeDao privilegeDao;

	
	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}

	@Resource(name="privilegeDao")
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	public List<Privilege> findTopPrivileges() {
		return privilegeDao.findTopPrivileges();
	}

	public List<Privilege> getByIds(Integer[] privilegeIds) {
		if(null == privilegeIds) {
			return Collections.EMPTY_LIST;
		}
		int[] ids = new int[privilegeIds.length];
		int index = 0;
		for(int id : privilegeIds) {
			ids[index++] = id;
		}
		return privilegeDao.getByIds(ids);
	}

	public List<String> findAllUrls() {
		return privilegeDao.findAllurls();
	}
	
	
}
