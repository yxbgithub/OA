package com.baidu.OA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

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

	public HibernateTemplate getHinernateTemplate() {
		return hinernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHinernateTemplate(HibernateTemplate hinernateTemplate) {
		this.hinernateTemplate = hinernateTemplate;
	}
	
	

}
