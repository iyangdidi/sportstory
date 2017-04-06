package com.sportstory.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EmbeddedId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportstory.dao.UserStateDao;
import com.sportstory.domain.UserState;

@Service
public class UserStateService {
	
	@Autowired
	private UserStateDao userStateDao;

	@Transactional
	public void createOrUpdateToken(String uid, String token){
			
			UserState userState = userStateDao.findByTokern(token);
			if(null == userState){//首次登陆
				userState = new UserState();			
				userState.setToken(token);
				userState.setUpdateTime(new Timestamp((new Date()).getTime()));
				userState.setUserId(uid);
				userStateDao.add(userState);
			}else{//重新登录
				userState.setToken(token);
				userState.setUpdateTime(new Timestamp((new Date()).getTime()));
				userStateDao.update(userState);
			}			

	}
}
