package com.czy.myoa.service;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.domain.User;

public interface UserService extends BaseDao<User>{
	
	public User getUserByLoginNamePassword(String loginName,String password);
	
}
