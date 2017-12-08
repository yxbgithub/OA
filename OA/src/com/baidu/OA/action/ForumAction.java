package com.baidu.OA.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.PageBean;
import com.baidu.OA.model.Topic;
import com.baidu.OA.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@Controller("forumAction")
@Scope("prototype")
public class ForumAction extends ModelDrivenAction<Forum> {
	/**
	 * 0:显示全部主题:不会生成where字句
	 * 1:只显示精华帖：where t.type = ?
	 */
	private int viewType = 0;
	/**
	 *0:默认排序（按最后更新时间排序，但所有置顶帖都在前面:order by (case when t.type = 2 then 2 else 0 end) 
	 *		desc,t.lastUpdate desc
	 *1:按最后更新时间排序   :orderBy t.lastUpdate ?                  
	 *2:按主题发表时间排序    :orderBy t.postDate  ?             
	 *3:按回复数量排序              :orderBy t.replyCount ?        
	 */
	private int orderBy = 0;
	/**
	 * true:升序
	 * false:降序
	 */
	private boolean asc = false;
	
	
	
	public String list() {
		List<Forum> forums = forumService.findAll();
		ActionContext.getContext().put("forums", forums);
		return "list";
	}
	
	public String forumShow() {
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		//v1取出全部的主题
		/*//以为要对topic排序，所以得单独按照一定的排序规则取出某一版块下的主题
		List<Topic> topics = topicService.getByForum(forum);
		ActionContext.getContext().put("topics", topics);*/
		
		//按分页要求取出主题
		/*PageBean pageBean = topicService.getPageBeanByForum(forum, currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);*/
		
		//按照分页及指定的排序要求取出主题
		/*List<Object> parameters = new ArrayList<Object>();
		String queryString = "from Topic t where t.forum = ?";
		parameters.add(forum);
		if(1 == viewType) {
			queryString += " and t.type = 1";
		}
		
		if(1 == orderBy) {
			queryString += " orderBy t.lastUpdate ?";
		} else if(2 == orderBy) {
			queryString += " orderBy t.postDate ?";
		} else if(3 == orderBy) {
			queryString += " orderBy t.replyCount ?";
		} else {
			queryString += " order by (case when t.type = 2 then 2 else 0 end) desc,t.lastUpdate desc";
		}
		
		if(orderBy != 0) {
			parameters.add((asc ? "asc" : "desc"));
		}*/
		
		//借助QueryHelper工具类拼接hql语句
		QueryHelper queryHelper = new QueryHelper(Topic.class,"t")//
			.addWhereCondition("t.forum =?", forum)//
			.addWhereCondition((1 == viewType), "t.type=?", new Integer(1))//
			.orderByClause((0 == orderBy), "(case when t.type = 2 then 2 else 0 end)", false)//
			.orderByClause((0 == orderBy), "t.lastUpdate", false)//
			.orderByClause((1 == orderBy), "t.lastUpdate", asc)//
			.orderByClause((2 == orderBy), "t.postDate", asc)//
			.orderByClause((3 == orderBy), "t.replyCount", asc);
		PageBean pageBean = topicService.getPageBeanByForum(currentPage,queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "forumShow";
	}

	//=========================================
	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}
	
}
