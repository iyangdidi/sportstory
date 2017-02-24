package com.sportstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportstory.cons.Url;
import com.sportstory.domain.User;
import com.sportstory.domain.request.RequestLogon;
import com.sportstory.util.JsonUtil;

import flexjson.JSON;

@Controller
public class ToolController {
	
	//curl -X POST -HContent-type:application/json;charset=utf-8 -d "{\"token\":\"22\",\"uid\":\"guest@ibm.com\"}" http://localhost:8080/sportstory/test/json
	String head = "curl -X POST -HContent-type:application/json;charset=utf-8 -d ";
	String urlhead = " http://localhost:8080/sportstory";
	
	@RequestMapping(Url.URL_tool_getCurl)
	public void getCurl(){
		RequestLogon request = new RequestLogon();
		User user = new User();
		user.setPhone("15652960625");
		request.setUser(user);
		String jsonString = JsonUtil.toJson(request);
		
		String curl = head + jsonString + urlhead + Url.URL_user_logon;
		System.out.print(curl);
	}

}
