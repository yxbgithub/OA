package com.baidu.OA.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.TopicDao;
import com.baidu.OA.model.Topic;

@Repository("topicDao")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getByForum(final int id) {
		List<Topic> topics = (List<Topic>) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return  session.createQuery("from Topic t where t.forum.id = :id order by (case when t.type = 2 then 2 else 0 end) desc,t.lastUpdate desc")//
						.setInteger("id", id)//
						.list();
				
			}
		});
		return topics;
	}

}
