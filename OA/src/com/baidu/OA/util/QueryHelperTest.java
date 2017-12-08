package com.baidu.OA.util;

import org.junit.Test;

import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Topic;

public class QueryHelperTest {
	private int viewType = 1;
	/**
	 *0:默认排序（按最后更新时间排序，但所有置顶帖都在前面:order by (case when t.type = 2 then 2 else 0 end) 
	 *		desc,t.lastUpdate desc
	 *1:按最后更新时间排序   :orderBy t.lastUpdate ?                  
	 *2:按主题发表时间排序    :orderBy t.postDate  ?             
	 *3:按回复数量排序              :orderBy t.replyCount ?        
	 */
	private int orderBy = 1;
	/**
	 * true:升序
	 * false:降序
	 */
	private boolean asc = true;
	
	@Test
	public final void testGetQueryString() {
		Forum forum = new Forum();
		QueryHelper queryHelper = new QueryHelper(Topic.class,"t")//
			.addWhereCondition("t.forum =?", forum)//
			.addWhereCondition((1 == viewType), "t.type=?", 1)//
			.orderByClause((0 == orderBy), "(case when t.type = 2 then 2 else 0 end)", false)//
			.orderByClause((0 == orderBy), "t.lastUpdate", false)//
			.orderByClause((1 == orderBy), "t.lastUpdate", asc)//
			.orderByClause((2 == orderBy), "t.postDate", asc)//
			.orderByClause((3 == orderBy), "t.replyCount", asc);
		System.out.println(queryHelper.getQueryListString());
	}

}
