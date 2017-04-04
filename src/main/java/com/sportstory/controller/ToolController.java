package com.sportstory.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.criteria.Order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportstory.cons.Url;
import com.sportstory.domain.User;
import com.sportstory.domain.request.RequestLogon;
import com.sportstory.util.IdUtil;
import com.sportstory.util.JsonUtil;

import flexjson.JSON;

@Controller
public class ToolController {
	
	//curl -X POST -HContent-type:application/json;charset=utf-8 -d "{\"token\":\"22\",\"uid\":\"guest@ibm.com\"}" http://localhost:8080/sportstory/test/json
	String head = "curl -X POST -HContent-type:application/json;charset=utf-8 -d ";
	String urlhead = " http://localhost:8080/sportstory";
	
	@RequestMapping("/curl/user/logon")
	public void getCurl_user_logon(){
		RequestLogon request = new RequestLogon();
		User user = new User();
		String uid = IdUtil.generateId();
		user.setUid(uid);
		user.setPhone("15652960625");
		user.setPassword("123456");
		user.setName("yangdi");//user.setName("杨迪");
		user.setNickname("diCome");//user.setNickname("迪迪加油");
		user.setEmail("iyangdi@yeah.net");
		user.setHeadImageUrl("http://7u2ouq.com2.z0.glb.qiniucdn.com/headimage.png");
		user.setBackgourdUrl("http://7u2r5d.com2.z0.glb.qiniucdn.com/background1.jpg");
		user.setGender(0);
		user.setBirthday(new Date(1992, 2, 1));
		user.setStature(170);
		user.setWeight(50);
		user.setProvince("Beijing");
		user.setCity("Bejing");
		user.setDistrict("Haidian");
		user.setAddress("Tsinghua 11-302");
		user.setAssignment("my beauty");
//		user.setProvince("北京");
//		user.setCity("北京市");
//		user.setDistrict("海淀区");
//		user.setAddress("清华大学11-302");
//		user.setAssignment("我最漂亮");
		user.setUserGroup(0);
		user.setWallet(new BigDecimal(0));
		user.setIsForbiden(0);		
		user.setCreateTime(new Timestamp((new Date()).getTime()));
		user.setUpdateTime(new Timestamp((new Date()).getTime()));
		
		request.setUid(uid);
		request.setToken("qwetryuigffgfhjk");
		request.setUser(user);
		
		String jsonString = JsonUtil.toJson(request);	
		this.formatCurl(jsonString);
	}
	
	public void formatCurl(String jsonString){
		jsonString.subSequence(1, jsonString.length()-2);
		jsonString = jsonString.replace("\"", "\\\"");
		jsonString = "\""+jsonString+"\"";
		String curl = head + jsonString + urlhead + Url.URL_user_logon;
		System.out.println("curl--------------");
		System.out.println(curl);
	}
	
	@RequestMapping("/curl/jsonformat")
	public void jsonFormat(@RequestParam String jsonStrinng){
		
	}
}
