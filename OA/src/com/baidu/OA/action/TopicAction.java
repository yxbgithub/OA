package com.baidu.OA.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.PageBean;
import com.baidu.OA.model.Reply;
import com.baidu.OA.model.Topic;
import com.baidu.OA.model.User;
import com.opensymphony.xwork2.ActionContext;

@Controller("topicAction")
@Scope("prototype")
public class TopicAction extends ModelDrivenAction<Topic> {
	private Integer forumId;
	
	public String topicShow() {
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
		//便于后面的对回复进行分页，我们单独去回复集合
		/*List<Reply> replies = replyService.getByTopic(topic);
		ActionContext.getContext().put("replies", replies);*/
		PageBean pageBean = replyService.getPageBeanByTopic(topic, currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "topicShow";
	}
	
	public String addUI() {
		return "saveUI";
	}
	
	public String add() {
		Topic topic = new Topic();
		
		topic.setTitle(model.getTitle());
		topic.setContent(model.getContent());
		if(null != forumId) {
		topic.setForum(forumService.getById(forumId.intValue()));
		}
		topic.setAuthor(getUser());
		topic.setIpAddr(getRequestIp());
		topicService.add(topic);
		//向context中放入一个topicId，以便于重定向的时候传参数
		ActionContext.getContext().put("topicId", topic.getId());
		return "toTopicShow";
	}

	
	public String setType() {
		Topic topic = topicService.getById(model.getId());
		//设置要更新的属性
		topic.setType(model.getType());
		topicService.update(topic);
		ActionContext.getContext().put("topicId", topic.getId());
		return "toTopicShow";
	}
	
	//===================================================
	public Integer getForumId() {
		return forumId;
	}

	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

}
