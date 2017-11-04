package com.baidu.OA.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.model.Reply;
import com.baidu.OA.model.Topic;
import com.baidu.OA.dao.ReplyDao;

@Repository("replyDao")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getByTopic(final int id) {
		
		List<Reply> replies = (List<Reply>) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createQuery("from Reply r where r.topic.id = :id order by r.postDate")//
				.setInteger("id", id)//
				.list();
				 
			}
		});
		return replies;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<Topic> getRecordListByForum(final int currentPage, final int pageSize,
			final Topic topic) {
		List<Topic> recordList = (List<Topic>) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return  session.createQuery("from Reply r where r.topic.id = :id order by r.postDate")//
						.setInteger("id", topic.getId())//
						.setFirstResult((currentPage-1)*pageSize)//
						.setMaxResults(pageSize)//
						.list();
				
			}
		});
		return recordList;
	}

}
