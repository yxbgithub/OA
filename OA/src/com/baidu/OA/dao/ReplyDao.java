package com.baidu.OA.dao;

import java.util.List;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Reply;
import com.baidu.OA.model.Topic;

public interface ReplyDao extends BaseDao<Reply>{

	/**
	 * 查询莫伊个主题下的所有回复，以回复时间来升序排列
	 * @param id
	 * @return
	 */
	List<Reply> getByTopic(int id);

	@Deprecated
	List<Topic> getRecordListByForum(int currentPage, int pageSize, Topic topic);

}
