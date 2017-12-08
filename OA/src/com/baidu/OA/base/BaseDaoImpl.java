package com.baidu.OA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.baidu.OA.model.PageBean;
import com.baidu.OA.util.Configuration;
import com.baidu.OA.util.ModelUtil;
import com.baidu.OA.util.QueryHelper;

/**
 * 实现baseDao里面定义的公共的方法，继承自该类的dao不用再去实现baseDao里面的方法
 * 
 * @author jack
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	private HibernateTemplate hinernateTemplate;
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
		clazz = (Class<T>) actualTypeArgument;
	}

	@Override
	public void save(T entity) {
		hinernateTemplate.save(entity);

	}

	@Override
	public void delete(int id) {
		hinernateTemplate.delete(getById(id));
	}

	@Override
	public T getById(int id) {
		return (T) hinernateTemplate.get(clazz, id);
	}

	@Override
	public void update(T entity) {
		hinernateTemplate.update(entity);
	}

	@Override
	public List<T> findAll() {
		String tableName = ModelUtil.getTableName(clazz);
		return (List<T>) hinernateTemplate.find("from " + tableName);
	}

	public HibernateTemplate getHinernateTemplate() {
		return hinernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHinernateTemplate(HibernateTemplate hinernateTemplate) {
		this.hinernateTemplate = hinernateTemplate;
	}

	@Override
	public List<T> getByIds(int[] ids) {
		List<T> list = new ArrayList<T>();
		for (int id : ids) {
			list.add(this.getById(id));
		}
		return list;
	}

	@Override
	public PageBean getRecordList(QueryHelper queryHelper, final int currentPage) {
		final String queryListString = queryHelper.getQueryListString();
		final List<Object> parameters = queryHelper.getParameters();
		final int pageSize = Configuration.getPageSize();

		// 查询数据列表
		List<T> recordList = (List<T>) this.getHinernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						if (null == parameters || (parameters.size() == 0)) {
							return Collections.emptyList();
						}
						Query q = session.createQuery(queryListString);
						for (int i = 0; i < parameters.size(); i++) {
							q.setParameter(i, parameters.get(i));
						}
						q.setFirstResult((currentPage - 1) * pageSize)//
								.setMaxResults(pageSize);
						return q.list();
					}
				});

		// 查询记录总数目
		final String queryCountString = queryHelper.getQueryCountString();

		Long recordCount = (Long) this.getHinernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						if (null == parameters || (parameters.size() == 0)) {
							return Collections.emptyList();
						}
						Query q = session.createQuery(queryCountString);// 创建查询过程
						for (int i = 0; i < parameters.size(); i++) {// 设置参数
							q.setParameter(i, parameters.get(i));
						}

						return q.uniqueResult();
					}
				});
		return new PageBean(currentPage, pageSize, recordCount.intValue(), recordList);
	}

}
