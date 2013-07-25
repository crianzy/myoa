package com.czy.myoa.service.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.base.BaseDaoImpl;
import com.czy.myoa.domain.User;
import com.czy.myoa.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService,
		BaseDao<User> {

	@Override
	public User getUserByLoginNamePassword(String loginName, String password) {
		Session session = getSession();
		return (User) session.createQuery("FROM User user WHERE user.loginName = ? AND user.password = ?")//
			.setParameter(0, loginName)//
			.setParameter(1, password)//
			.uniqueResult();
	}

}
