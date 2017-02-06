package com.sportstory.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T>{
	
	private Class<T> endityClass;
	
//	@Autowired
//	数据库的操作模板
//	
//	public List<T> getAll(){
//		return (T)模板操作
//	}
}
