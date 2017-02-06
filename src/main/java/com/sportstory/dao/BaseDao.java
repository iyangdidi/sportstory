package com.sportstory.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

public class BaseDao<T>{
	
	private Class<T> endityClass;
	
	//通过反射获得子类确定的泛型
	public BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		endityClass = (Class)params[0];
	}
	
	//TODO
	//通用的数据库操作
//	@Autowired
//	数据库的操作模板
//	
//	public List<T> getAll(){
//		return (T)模板操作
//	}
	
	
}
