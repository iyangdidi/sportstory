package com.sportstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportstory.domain.request.RequestCommon;
import com.sportstory.domain.response.ResponseCommon;

@Controller
public class VController {
	
	@RequestMapping("/vcode/send")
	public ResponseCommon send(@RequestBody RequestCommon request){
		ResponseCommon response = new ResponseCommon();
		
		//TODO
		//接入短信接口
		
		return response;
	}
}
