package com.czy.myoa.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.czy.myoa.base.BaseDaoImpl;
import com.czy.myoa.domain.Privilege;
import com.czy.myoa.service.PrivilegeService;

@Service
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeService {

	@Override
	public List<Privilege> getTopPrivilegList() {
		return getSession().createQuery(
				"FROM Privilege p WHERE p.parent IS NULL").list();
	}

	@Override
	public List<String> getAllPrivilegUrlList() {
		Session session = getSession();
		List<String> urls = null;
		urls = session.createQuery(
				"SELECT p.url FROM Privilege p WHERE p.url IS NOT NULL").list();
		return urls;
	}

}
