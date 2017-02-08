package com.sportstory.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sportstory.domain.Test;
import com.sportstory.domain.TestMapper;

@Repository
public class TestDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void getTestTableById(){
		String sql = "select * from test where id = ?";
		Object[] args = new Object[]{1};
		
		List testList = new ArrayList<Test>();
		testList = jdbcTemplate.query(sql, args, new TestMapper());		
		
		Test test = (Test)testList.get(0);
		
		System.out.println("test/jdbc ... table content: "+test.getContent());
	}

}
