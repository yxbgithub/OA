package com.baidu.OA.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.baidu.OA.dao.RoleDao;
import com.baidu.OA.model.Role;

@Service("roleService")
public class RoleService {
	private RoleDao roleDao;

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Resource(name="roleDaoImpl")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void add(Role role) {
		roleDao.save(role);
	}

	public Role getById(int id) {
		return roleDao.getById(id);
	}

	public void edit(Role role) {
		roleDao.update(role);
		
	}

	public void delete(Role role) {
		roleDao.delete(role.getId());
		
	}

	

}
