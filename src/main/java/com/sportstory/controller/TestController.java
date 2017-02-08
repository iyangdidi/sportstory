package com.sportstory.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportstory.cons.UrlConstants;
import com.sportstory.dao.TestDao;
import com.sportstory.domain.User;
import com.sportstory.service.UserService;


@Controller
public class TestController {
		
		@Autowired
	    private UserService userService; 
		@Autowired
	    private TestDao testDao; 
		
		//private static final Logger log = Logger.getLogger(TestController.class);
		
		@RequestMapping(UrlConstants.URE)
		public void test(){
			System.out.println("test...");
		}
	
		@RequestMapping(UrlConstants.URE_test_mybatis)
	    public ModelAndView getIndex(){      
	        ModelAndView mav = new ModelAndView("index");   
	        return mav;    
	    }   
		
		@RequestMapping(UrlConstants.URE_test_jdbc)
		public void testJDBC(){
			testDao.getTestTableById();
		}
}
