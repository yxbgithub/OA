package com.baidu.OA.base;

import java.util.List;

import com.baidu.OA.model.PageBean;
import com.baidu.OA.util.QueryHelper;

/**
 * 定义所有Dao公共的方法
 * @author jack
 *
 * @param <T>
 */
public interface BaseDao<T> {
	public void save(T entity);
	public void delete(int id);
	public T getById(int id);
	public List<T> getByIds(int[] ids);
	public void update(T entity);
	public List<T> findAll();
	
	/**
	 * 查询要显示的分页的数据列表以及总的记录数，将查询结果封装为一个PageBean返回
	 * @param queryHelper
	 * @param currentPage
	 * @return
	 */
	public PageBean getRecordList(QueryHelper queryHelper,int currentPage);
	
}
