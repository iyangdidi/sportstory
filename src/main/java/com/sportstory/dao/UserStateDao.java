package com.sportstory.dao;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sportstory.domain.User;
import com.sportstory.domain.UserState;

@Repository
public class UserStateDao extends BaseDao<UserState>{
	
	@Transactional
	public UserState findByTokern(String token){
		String where = wheresql + " token=?1";
		params = new Object[]{token};
		
		List<UserState> res = selectQuery(where, params);
		if(res.size()>0)
			return res.get(0);
		else
			return null;
	}
	
}
