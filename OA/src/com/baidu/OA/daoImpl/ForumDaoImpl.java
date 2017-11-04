package com.baidu.OA.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.ForumDao;
import com.baidu.OA.model.Forum;
import com.baidu.OA.model.Topic;
@Repository("forumDao")
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao {

	/**
	 * 实现将forum上移
	 */
	@Override
	public void moveUp(int id) {
		//重数据库中取出需要交换位置的记录
		Forum forum = this.getById(id);
		Forum other = this.getUpper(forum.getPosition());
		
		//如果是最顶上的，将不能上移
		if(null == other) {
			return;
		}
		//交换两个记录的位置属性
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
		//更新到数据库(因为是持久化对象，也可以不写update语句，事务提交的时候会自动update已经更改的属性）
		this.update(forum);
		this.update(other);
	}

	/**
	 * 得到要交换position属性的记录
	 * @param position
	 * @return
	 */
	public Forum getUpper(final int position) {
		return (Forum) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createQuery("from t_forum f where f.position < :position order by f.position desc")//
						.setInteger("position", position)//
						.setFirstResult(0)//
						.setMaxResults(1)//
						.uniqueResult();
			}
		});
	}

	
	@Override
	public void moveDown(int id) {
		//取得要互换position属性的记录
		Forum forum = this.getById(id);
		Forum other = this.getDown(forum.getPosition());
		
		//如果是已经是最底下一个，将不能下移
		if(null == other) {
			return;
		}
		//交换position属性
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
	}

	public Forum getDown(final int position) {
			return (Forum) this.getHinernateTemplate().execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					return session.createQuery("from t_forum f where f.position > :position order by f.position asc")//
							.setInteger("position", position)//
							.setFirstResult(0)//
							.setMaxResults(1)//
							.uniqueResult();
				}
			});
	}
	
	/**
	 * 重写save方法，将position属性和主键id挂钩，实现每条记录的position不重复，并且没有并发问题（如果我们自己将数据库的position属性取出来，
	 * 然后加上一个数值，然后放入数据库的话，当有多个线程同时执行的时候，可能加入的position属性会重复
	 * 
	 */
	@Override
	public void save(Forum entity) {
		//将实体存入数据库
		super.save(entity);
		//取出entity的主键值赋值给position属性
		entity.setPosition(entity.getId());
	}
	

	/**
	 * 重写findAll方法，将查询结果排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		return this.getHinernateTemplate().find("from t_forum f order by f.position asc");
	}

}
