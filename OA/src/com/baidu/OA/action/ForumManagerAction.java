package com.baidu.OA.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.Forum;
import com.opensymphony.xwork2.ActionContext;

@Controller("forumManagerAction")
@Scope("prototype")
public class ForumManagerAction extends ModelDrivenAction<Forum> {

	public String list() {
		List<Forum> forums = forumService.findAll();
		ActionContext.getContext().put("forums", forums);
		return "list";
	}
	
	public String delete() {
		forumService.delete(model);
		return "toList";
	}
	
	public String addUI() {
		return "saveUI";
	}
	
	public String add() {
		forumService.add(model);
		return "toList";
	}
	
	public String editUI() {
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		return "saveUI";
	}
	
	public String edit() {
		forumService.update(model);
		return "toList";
	}
	
	public String moveUp() {
		forumService.moveUp(model);
		return "toList";
	}
	
	public String moveDown() {
		forumService.moveDown(model);
		return "toList";
	}
}
