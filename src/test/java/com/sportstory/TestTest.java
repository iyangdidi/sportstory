package com.sportstory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.util.AssertException;
import com.sportstory.dao.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	TestDao testDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testForJpa() {
		testDao.jpa_getTestTableById();
	}
}
