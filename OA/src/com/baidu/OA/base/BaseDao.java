package com.baidu.OA.base;

import java.util.List;


public interface BaseDao<T> {
	public void save(T entity);
	public void delete(int id);
	public T getById(int id);
	public void update(T entity);
	public List<T> findAll();
	
}
