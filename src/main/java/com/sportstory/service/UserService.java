package com.sportstory.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportstory.dao.UserDao;
import com.sportstory.domain.Test;
import com.sportstory.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	
	public void addUser(User user){
		userDao.add(user);
	}
	
	public User findUserById(int id){
		return userDao.getObjectById(id);
	}
	
	//检查用户是否已经注册
	public boolean isUserRegisted(User user){
		
		if(null!=userDao.findUserByPhone(user.getPhone())){
			return true;
		}
		
		return false;
	}
}
