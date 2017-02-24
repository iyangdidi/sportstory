package com.sportstory.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sportstory.cons.Url;
import com.sportstory.dao.TestDao;
import com.sportstory.domain.User;
import com.sportstory.domain.request.AbstractRequest;
import com.sportstory.domain.request.RequestTest;
import com.sportstory.domain.response.ResponseTest;
import com.sportstory.service.UserService;
import com.sportstory.util.JsonUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

//@Api(value = "user-api", description = "有关于用户的CURD操作", position = 5)
@Controller
public class TestController {

	@Autowired
	private UserService userService;
	@Autowired
	private TestDao testDao;

	// private static final Logger log = Logger.getLogger(TestController.class);

	@RequestMapping("/getJson")
	public void getJson() {
		ResponseTest req = new ResponseTest();
		String jsonString =  JsonUtil.toJson(req);
		
		System.out.print(jsonString);
	}
	
	@RequestMapping(Url.URL)
	public void test() {
		System.out.println("test...");
	}

	@RequestMapping(Url.URL_test_mybatis)
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping(Url.URL_test_jdbc)
	public void testJDBC() {
		testDao.jdbc_getTestTableById();
	}

	@RequestMapping(Url.URL_test_jpa)
	public void testJPA() {
		testDao.jpa_getTestTableById();
	}

	//@ApiOperation(value = "注册", notes = "注册用户", position = 3)
	@RequestMapping(value={Url.URL_test_json}, method = RequestMethod.POST)
	public @ResponseBody
	ResponseTest testJson(@RequestBody RequestTest req) {
		ResponseTest res = new ResponseTest();
		
		System.out.print("test...json");

		return res;
	}
	
	@RequestMapping("/api")
	public String test2() {
		System.out.println("test...api");
		return "index";
	}
}
