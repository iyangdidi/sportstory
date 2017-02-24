package com.sportstory.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sportstory.cons.Url;
import com.sportstory.domain.User;
import com.sportstory.domain.request.RequestLogon;
import com.sportstory.domain.request.ResponseCommon;
import com.sportstory.domain.request.user.RequestLogin;
import com.sportstory.domain.response.AbstractResponse;
import com.sportstory.domain.response.user.ResponseLogin;
import com.sportstory.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(Url.URL_user_login)
	@ResponseBody
	public ResponseLogin login(@RequestBody RequestLogin request){
		ResponseLogin response = new ResponseLogin();
		
		//检查是否已经注册
		//TODO
		
		return response;
	}
	
	@RequestMapping(Url.URL_user_logon)
	@ResponseBody
	public ResponseCommon logon(@RequestBody RequestLogon request){
		ResponseCommon response = new ResponseCommon();
		
		//检查是否已经注册
		if(userService.isUserRegisted(request.getUser())){
			response.setStatus("001");
			response.setContent("用户已经注册");
		}
		
		return response;
	}
}
