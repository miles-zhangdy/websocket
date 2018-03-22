package com.ssm.common.model;

public class SupperVO {

	private Integer page;
	// 查询开始条数,翻页的开始条数位置
	private Integer beginIndex;
	// 每页的条数
	private Integer pageSize;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
