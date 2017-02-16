package com.sportstory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * DAO基类
 * 
 * @author fengxm
 * 
 */
public class BasicDao {

	// @Autowired
	// rotected JdbcMysqlDao jdbcTemplateObject;

	@Autowired
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}
