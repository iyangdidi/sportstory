package com.sportstory.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sportstory.cons.Constants;
import com.sportstory.cons.StateEnum;
import com.sportstory.cons.Url;
import com.sportstory.dao.UserDao;
import com.sportstory.domain.User;
import com.sportstory.domain.request.user.RequestLogin;
import com.sportstory.domain.request.user.RequestLogon;
import com.sportstory.domain.response.AbstractResponse;
import com.sportstory.domain.response.ResponseCommon;
import com.sportstory.domain.response.user.ResponseLogin;
import com.sportstory.service.UserService;
import com.sportstory.service.UserStateService;
import com.sportstory.util.SecurityUtil;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private UserDao userDao;
	@Resource
	private UserStateService userStateService;

	@RequestMapping("/user/login")
	@ResponseBody
	public ResponseLogin login(@RequestBody RequestLogin request){
		ResponseLogin response = new ResponseLogin();
		
		//验证用户名密码
		User user = userDao.findByPhoneAndPsd(request.getPhone(), request.getPassword());
		if(null == user){//登陆错误
			response.setStatus(StateEnum.LoginError.getIndex());
			response.setContent(StateEnum.LoginError.getName());
		}else{
			//插入token
			long time = (new Date()).getTime();
			String token = SecurityUtil.getToken(request.getPhone(), request.getPassword(), time);
			try {
				userStateService.createOrUpdateToken(user.getUid(), token);
				response.setUid(user.getUid());
				response.setToken(token);
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(StateEnum.Error.getIndex());
				response.setContent(StateEnum.Error.getName());
			}
		}
		
		return response;
	}
	
	@RequestMapping("/user/logon")
	@ResponseBody
	public ResponseCommon logon(@RequestBody RequestLogon request){
		ResponseCommon response = new ResponseCommon();
		
		//检查是否已经注册
		if(userService.isUserRegisted(request.getPhone())){
			response.setStatus(StateEnum.Registed.getIndex());
			response.setContent(StateEnum.Registed.getName());
		}else{
			try{
				//插入用户
				User user = new User();
				user.setPhone(request.getPhone());
				user.setPassword(request.getPassword());
				userService.addUser(user);
				//插入token
				//TODO
				//返回用户token
				//TODO
			}catch(Exception e){
				e.printStackTrace();
				response.setStatus(StateEnum.ParamError.getIndex());
				response.setContent(StateEnum.ParamError.getName());
			}			
		}		
		return response;
	}
}
