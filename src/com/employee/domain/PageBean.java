package com.employee.domain;

import java.util.List;

/**
 * 分页Bean
 * @author Administrator
 * @date 2016年12月24日
 * @param <T>
 */
public class PageBean<T>{
	private Integer currentPage;//当前页数
	private Integer pageCount;//每页显示记录数
	private Integer pageSize;//总页数
	private Integer totalSize;//总记录数
	private List<T> list;     //每页显示的数据
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalSize() {
		return totalSize;
	}
	
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
