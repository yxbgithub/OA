package com.baidu.OA.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baidu.OA.dao.ReplyDao;

@Entity
@Table(name = "t_reply")
public class Reply extends Article {
	private Topic topic;
	private boolean deleted;
	
	@ManyToOne
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
