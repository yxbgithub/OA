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

import com.baidu.OA.util.ModelUtil;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	private HibernateTemplate hinernateTemplate;
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
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
		return (T)hinernateTemplate.get(clazz, id);
	}

	
	@Override
	public void update(T entity) {
		hinernateTemplate.update(entity);
	}

	@Override
	public List<T> findAll() {
		String tableName = ModelUtil.getTableName(clazz);
		return  (List<T>)hinernateTemplate.find("from " + tableName);
	}
	

	public HibernateTemplate getHinernateTemplate() {
		return hinernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHinernateTemplate(HibernateTemplate hinernateTemplate) {
		this.hinernateTemplate = hinernateTemplate;
	}

	@Override
	public List<T> getByIds(int[] ids) {
		List<T> list = new ArrayList<T>();
		for(int id : ids) {
			list.add(this.getById(id));
		}
		return list;
	}

	@Override
	public List<T> getRecordList(final String queryString, final List parameters, final int currentPage, final int pageSize) {
		List<T> recordList = (List<T>) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery(queryString);
				if(null == parameters || (parameters.size() == 0)) {
					return Collections.emptyList();
				}
				for(int i=0; i<parameters.size(); i++) {
					q.setParameter(i, parameters.get(i));
				}
				q.setFirstResult((currentPage-1)*pageSize)//
					.setMaxResults(pageSize);
				return q.list();
			}
		});
		return recordList;
	}

	
	
	

}
