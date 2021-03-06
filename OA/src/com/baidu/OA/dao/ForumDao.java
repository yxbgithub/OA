package com.baidu.OA.dao;

import java.util.List;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Topic;

public interface ForumDao extends BaseDao<Forum>{

	void moveUp(int id);

	void moveDown(int id);
}
