package com.baidu.OA.service;

import java.util.ArrayList;
import java.util.Collections;
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


	public void delete(Role role) {
		roleDao.delete(role.getId());
		
	}

	public void edit(Role model) {
		roleDao.update(model);
		
	}

	public List<Role> getByIds(Integer[] roleIds) {
		if(null == roleIds) {
			//当传进来的数组为空的时候，我们不是返回一个null，返回null的话外面有可能报空指针异常，我们返回一个集合，但是这个集合是空的，不占用资源（
			//默认情况我们new 一个list或者其他集合，他们的初始大小是10个，而Collections.EMPTY_LIST大小为零，且不可改变
			return Collections.EMPTY_LIST;
		}
		List<Role> roles = new ArrayList<Role>();
		for(int id : roleIds) {
			roles.add(this.getById(id));
		}
		return roles;
	}

	

}
