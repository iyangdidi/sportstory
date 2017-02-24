package com.sportstory.util;

import java.util.List;

public class QueryResult<T> {
	List<T> resultList;
	long totalrecord;
	
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
	
}
