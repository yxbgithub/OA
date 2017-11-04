package com.baidu.OA.model;

import java.util.List;

public class PageBean {
	//可以通过其他参数计算出来
	private int beginIndex;//开始页码
	private int endIndex;//结束页码
	private int pageCount;//一共有多少页
	
	private int currentPage;//当前页码
	private int pageSize;//一页显示多少条记录
	private int recordCount;//一共有多少条记录
	private List recordList;//当前页面需要显示的数据
	
	public PageBean(int currentPage, int pageSize, int recordCount, List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		pageCount = (recordCount + pageSize - 1)/pageSize;//计算总的页数
		
		//1:如果总的页数《=10的话，就全部显示
		if(pageCount <= 10) {
			beginIndex = 1;
			endIndex = pageCount;
			return;
		} 
		//2：如果总的页数大于10,开始页面为currentpage-4，结束页码是currentPage+5
		beginIndex = currentPage - 4;
		endIndex = currentPage + 5;
		//a:如果开始页码小于1，则开始页码为1
		if(beginIndex < 1) {
			beginIndex = 1;
			endIndex = 10;
			return;
		}
		if(endIndex > pageCount) {
			beginIndex = pageCount -10 + 1;//包含两个编辑pageCount=15 beginIndex=6 
			endIndex = pageCount;
		}
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	
}