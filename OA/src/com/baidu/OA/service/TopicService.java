package com.baidu.OA.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.TopicDao;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Topic;

@Service("topicService")
public class TopicService {
	private TopicDao topicDao;

	
	public TopicDao getTopicDao() {
		return topicDao;
	}

	@Resource(name="topicDao")
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public void add(Topic topic) {
		topic.setPostDate(new Date());
		topic.setLastUpdate(topic.getPostDate());
		topic.setType(Topic.TYPE_NORMAL);
		topicDao.save(topic);
		
		Forum forum = topic.getForum();
		//更新版块的相关属性：topicCount + 1
		forum.setTopicCount(forum.getTopicCount() + 1);
		//更新版块的相关属性：articleCount + 1
		forum.setArticleCount(forum.getArticleCount() + 1);
		//更新版块的相关属性：lastTopic ---》当前新建的主题
		forum.setLastTopic(topic);
		
	}

	public Topic getById(int id) {
		return topicDao.getById(id);
	}

	public List<Topic> getByForum(Forum forum) {
		if(null == forum) {
			return Collections.emptyList();
		}
		return topicDao.getByForum(forum.getId());
	}

	public void update(Topic topic) {
		topicDao.update(topic);
	}
}
