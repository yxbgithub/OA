package com.baidu.OA.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.ReplyDao;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Reply;
import com.baidu.OA.model.Topic;

@Service("replyService")
public class ReplyService {
	private ReplyDao replyDao;

	
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	
	@Resource(name="replyDao")
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public List<Reply> getByTopic(Topic topic) {
		if(null == topic) {
			return Collections.emptyList();
		}
		return replyDao.getByTopic(topic.getId());
	}

	public void add(Reply reply) {
		reply.setDeleted(false);
		reply.setPostDate(new Date());
		replyDao.save(reply);

		// 更新forum的属性：articleCount + 1
		Forum forum = reply.getTopic().getForum();
		forum.setArticleCount(forum.getArticleCount() + 1);
		// 更新topic属性：replyCount + 1
		Topic topic = reply.getTopic();
		topic.setReplyCount(topic.getReplyCount() + 1);
		// 更新topic属性：astReply ---》当前新建的回复
		topic.setLastReply(reply);
		// 更新topic属性：lastUpdate ---》当前新建回复时间
		topic.setLastUpdate(reply.getPostDate());
	}
	
}
