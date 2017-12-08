package com.baidu.OA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_template")
public class Template implements Serializable {
	private int id;
	private String name;
	private String definationName;
	private String path;//用于记录文件在磁盘的路径
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefinationName() {
		return definationName;
	}
	public void setDefinationName(String definationName) {
		this.definationName = definationName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
