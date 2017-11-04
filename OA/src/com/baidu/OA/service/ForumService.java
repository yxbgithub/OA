package com.baidu.OA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.OA.dao.ForumDao;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.PageBean;
import com.baidu.OA.model.Topic;
import com.baidu.OA.util.Configuration;

@Service("forumService")
public class ForumService {
	ForumDao forumDao;

	public ForumDao getForumDao() {
		return forumDao;
	}

	@Resource(name="forumDao")
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public List<Forum> findAll() {
		return forumDao.findAll();
	}

	public void add(Forum model) {
		forumDao.save(model);
		
	}

	public Forum getById(int id) {
		return forumDao.getById(id);
	}

	public void update(Forum model) {
		//从数据库中以model的id取出一个对象，然后设置要修改的属性，最后update，这样做只会更新被修改的属性，而像position属性不会被修改，
		//如果直接update(model)的话，会更新所有的属性
		Forum forum = forumDao.getById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumDao.update(forum);
	}

	public void delete(Forum model) {
		forumDao.delete(model.getId());
	}

	public void moveUp(Forum model) {
		forumDao.moveUp(model.getId());
		
	}

	public void moveDown(Forum model) {
		forumDao.moveDown(model.getId());
	}

}
