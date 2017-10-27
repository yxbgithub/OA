package com.baidu.OA.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "t_user")
public class User {
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
	

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	@ManyToMany
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
