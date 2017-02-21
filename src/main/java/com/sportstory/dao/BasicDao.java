package com.sportstory.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * DAO基类
 * 
 * @author fengxm
 * 
 */
public abstract class BasicDao implements Serializable{

	// @Autowired
	// rotected JdbcMysqlDao jdbcTemplateObject;

	@Autowired
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}
