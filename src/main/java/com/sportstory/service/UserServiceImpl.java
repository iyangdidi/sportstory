package com.sportstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportstory.dao.UserDao;
import com.sportstory.domain.User;

@Service  
public class UserServiceImpl implements UserService {

	@Autowired  
    private UserDao userDao;  
  
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
          
    }  
}
