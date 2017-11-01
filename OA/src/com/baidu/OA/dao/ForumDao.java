package com.baidu.OA.dao;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Forum;

public interface ForumDao extends BaseDao<Forum>{

	void moveUp(int id);

	void moveDown(int id);

}
