package com.sportstory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//JDBC test
public class TestMapper implements RowMapper<Test> {

	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {

		Test test = new Test();

		test.setId(rs.getInt("id"));
		test.setContent(rs.getString("content"));

		return test;
	}
}
