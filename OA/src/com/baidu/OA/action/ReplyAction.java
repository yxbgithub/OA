package com.baidu.OA.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.BaseAction;
import com.baidu.OA.model.Reply;

@Controller("replyAction")
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {
	private Integer topicId;
	
	public String addUI() {
		return "saveUI";
	}
	
	public String add() {
		Reply reply = new Reply();
		//设置数据
		reply.setAuthor(getUser());
		reply.setContent(model.getContent());
		if(topicId != null) {
			reply.setTopic(topicService.getById(topicId.intValue()));
		}
		replyService.add(reply);
		return "toTopicShow";
	}

	//==========================
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
}
