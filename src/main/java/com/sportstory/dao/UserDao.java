package com.sportstory.dao;

import com.sportstory.domain.User;

public interface UserDao {
	
	/**
	 * @param userId
	 * @return User
	 */
	public User selectUserById(Integer userId);  

}
