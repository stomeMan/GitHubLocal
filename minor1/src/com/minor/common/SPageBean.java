package com.minor.common;

import java.util.List;

public class SPageBean {
	//分页偏置，假设每页10条记录，第二页，则offset=11,pageSize=10
	private int offset;
	private int pageSize;
	
	//总记录数
	private int total;
	//分页数据
	private List datas;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
