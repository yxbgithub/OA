package com.baidu.OA.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.opensymphony.xwork2.ActionContext;

@Entity(name = "t_user")
public class User implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 288611612483108017L;
	private int id;
	private String loginName;
	private String name;
	private String gender;
	private String password;
	private String phoneNumber;
	private String email;
	private String description;
	private String avatar;
	private Set<Role> roles;
	private Department department;
	

	public boolean hasPrivilegeByName(String privilegeName) {
		if(isAdmin()) {
			return true;
		}
		for(Role role : roles) {
			for(Privilege privilege : role.getPrivileges()) {
				if(privilege.getName().equals(privilegeName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 使用url判断用户是否有权限
	 * @param privilegeUrl
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privilegeUrl) {
		//如果是超级管理员，返回true，认为有权限
		if(isAdmin()) {
			return true;
		}
		//将传过来的url进行处理，如果后面带“UI”，则把“UI”截掉
		if(privilegeUrl.endsWith("UI")) {
			privilegeUrl = privilegeUrl.substring(0, privilegeUrl.indexOf("UI"));
		}
		//如果传过来的url不在数据库的权限列表里，表明是登陆就可以使用的权限，返回true
		Collection<String> privilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("privilegeUrls");
		if(!privilegeUrls.contains(privilegeUrl)) {
			return true;
		}
		//将传过来的url和用户所拥有的全新用equals比较，相等返回true。
		for(Role role : roles) {
			for(Privilege privilege :role.getPrivileges()) {
				//将privilege.getUrl()写在equals括号里面，因为有些权限是没有url的（比如系统管理），privilege.getUrl()。equals这样使用可能会抛空指针异常
				if(privilegeUrl.equals(privilege.getUrl())) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Transient
	private boolean isAdmin() {
		if("admin".equals(loginName)) {
			return true;
		}
		return false;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Role> getRoles() {
		return roles;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public String getDescription() {
		return description;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}


	public String getLoginName() {
		return loginName;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
