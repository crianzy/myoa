package com.czy.myoa.service;

import java.util.List;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.domain.Privilege;

public interface PrivilegeService extends BaseDao<Privilege>{

	public List<Privilege> getTopPrivilegList();

	public List<String> getAllPrivilegUrlList();
}
