package com.sportstory.service;

import com.sportstory.domain.User;

public interface UserService {
	User selectUserById(Integer userId);  
}
