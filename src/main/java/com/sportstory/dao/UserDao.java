package com.sportstory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sportstory.domain.User;

@Repository
public class UserDao extends BaseDao<User> {
	
	public String wheresql = " where 1=1 and ";
	public String ordersql;
	Object[] params;
	
	@Transactional
	public User findUserByPhone(String phone){
		String where = wheresql + " phone=?1";
		params = new Object[]{phone};
		
		List<User> res = selectQuery(where, params);
		if(res.size()>0)
			return res.get(0);
		else
			return null;
	}
	

}
