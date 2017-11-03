package com.baidu.OA.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_topic")
public class Topic extends Article{
	/**
	 * 帖子的类型
	 */
	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_BEST = 1;
	public static final int TYPE_TOP = 2;
	
	private Forum forum;
	private String ipAddr;
	private Reply lastReply;
	private Date lastUpdate;
	private Set<Reply> replies;
	private String title;
	private int type;
	private int replyCount;

	@ManyToOne
	public Forum getForum() {
		return forum;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	@OneToOne
	@JoinColumn(unique=true)
	public Reply getLastReply() {
		return lastReply;
	}

	@Column(columnDefinition="timestamp")
	public Date getLastUpdate() {
		return lastUpdate;
	}

	@OneToMany(mappedBy="topic")
	public Set<Reply> getReplies() {
		return replies;
	}

	public String getTitle() {
		return title;
	}

	public int getType() {
		return type;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
}
