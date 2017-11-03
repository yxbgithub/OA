package com.baidu.OA.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.baidu.OA.base.BaseAction;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Topic;
import com.opensymphony.xwork2.ActionContext;

@Controller("forumAction")
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
	
	public String list() {
		List<Forum> forums = forumService.findAll();
		ActionContext.getContext().put("forums", forums);
		return "list";
	}
	
	public String forumShow() {
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		
		//以为要对topic排序，所以得单独按照一定的排序规则取出某一版块下的主题
		List<Topic> topics = topicService.getByForum(forum);
		ActionContext.getContext().put("topics", topics);
		return "forumShow";
	}
}
