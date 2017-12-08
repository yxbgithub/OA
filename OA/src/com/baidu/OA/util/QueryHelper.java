package com.baidu.OA.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	private static String whiteSpace = " ";
	private String queryString;
	private String fromClause;
	private String whereClause;
	private String orderByClause;
	List<Object> parameters = new ArrayList<Object>();
	
	public QueryHelper(Class clazz, String alias) {
		fromClause = "from" + whiteSpace + clazz.getSimpleName() + whiteSpace + alias;
	}
	
	
	public QueryHelper addWhereCondition(String condition,Object... arges) {
		if(whereClause == null) {
			whereClause =	whiteSpace + "where" + whiteSpace + condition;
		} else{
			whereClause += whiteSpace + "and" + whiteSpace + condition;
		}
		if(arges != null && (arges.length !=0)){
			for(Object arge : arges) {
				parameters.add(arge);
			}
		}
		return this;
	}
	
	
	public QueryHelper orderByClause(String property,boolean asc) {
		if(null == orderByClause) {
			orderByClause = whiteSpace + "order by" + whiteSpace + property + whiteSpace + (asc ? "asc" : "desc");
		}else {
			orderByClause += "," + property + whiteSpace + (asc ? "asc" : "desc");
		}
		return this;
	}
	
	public QueryHelper addWhereCondition(boolean append,String condition,Object... arges) {
		if(append) {
			addWhereCondition(condition,arges);
		}
		return this;
	}
	
	public QueryHelper orderByClause(boolean append,String property,boolean asc) {
		if(append) {
			orderByClause(property,asc);
		}
		return this;
	}

	/**
	 * 获取查询数据列表的HQL语句
	 * 
	 * @return
	 */
	public String getQueryListString() {
		return queryString = fromClause + whereClause + orderByClause;
	}
	
	/**
	 * 获取查询总记录数的HQL语句（没有OrderBy子句）
	 * 
	 * @return
	 */
	public String getQueryCountString() {
		return "select count(*) " + fromClause + whereClause;
	}

	public List<Object> getParameters() {
		return parameters;
	}
}
