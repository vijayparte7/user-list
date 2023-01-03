package com.vijay.userlist.util;

public class SortData {
	private int offset;
	private int pageSize;
	private String field;
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
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	@Override
	public String toString() {
		return "SortData [offset=" + offset + ", pageSize=" + pageSize + ", field=" + field + "]";
	}
	
}
