package com.sportstory.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportstory.domain.User;
import com.sportstory.service.UserService;


@Controller
@RequestMapping("/test")
public class TestController {
		
		@Autowired
	    private UserService userService; 
		
		//private static final Logger log = Logger.getLogger(TestController.class);
	
		@RequestMapping("/check_db")
	    public ModelAndView getIndex(){      
	        ModelAndView mav = new ModelAndView("index");   
	        User user = userService.selectUserById(1);  
	        mav.addObject("user", user);   

	        return mav;    
	    }   
		
		public void checkGitCommit(){}
}
