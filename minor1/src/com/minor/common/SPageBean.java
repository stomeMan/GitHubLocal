package com.minor.common;

import java.util.List;

public class SPageBean {
	//��ҳƫ�ã�����ÿҳ10����¼���ڶ�ҳ����offset=11,pageSize=10
	private int offset;
	private int pageSize;
	
	//�ܼ�¼��
	private int total;
	//��ҳ����
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
