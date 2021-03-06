package com.javaweb.util.entity;

public class Page {
	  
	private Long currentPage = 1L;//默认当前第1页
	
	private Long pageSize = 10L;//默认每页显示10条 
	
	private Long totalSize = 0L;//默认一共0条数据
	
	private Long totalPage = 0L;//默认一共0页
	
	private Object data;//数据
	
	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage>=1?currentPage:1;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize>0?pageSize:10;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize>=0?totalSize:0;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		if(pageSize>0){
			if(totalSize%pageSize==0){
				this.totalPage = totalSize/pageSize;
			}else{
				this.totalPage = totalSize/pageSize+1;
			}
		}
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	//获取数据截取开始位
	public Long getSubStart() {
		if(currentPage==1){
			return 0L;
		}else{
			return (currentPage-1)*pageSize;
		}
	}

	//获取数据截取结束位
	public Long getSubEnd() {
		Long endStart;
		if(currentPage==1){
			endStart = pageSize;
		}else{
			endStart = currentPage*pageSize;
		}
		if(endStart<=totalSize){
			return endStart;
		}else{
			return totalSize;
		}
	}
	
}
