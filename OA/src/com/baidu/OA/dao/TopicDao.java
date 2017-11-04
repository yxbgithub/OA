package com.baidu.OA.dao;

import java.util.List;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Topic;

public interface TopicDao extends BaseDao<Topic>{
	/**
	 * 找出某一版块下的帖子，按照一定的排序方式：置顶贴排在最前面，其余的按照
	 * 最后更新时间进行排序
	 * @param id
	 * @return
	 */
	List<Topic> getByForum(int id);
	
	@Deprecated
	List<Topic> getRecordListByForum(int currentPage, int pageSize, Forum forum);

}
