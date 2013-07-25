package com.czy.myoa.service.impl;

import org.springframework.stereotype.Service;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.base.BaseDaoImpl;
import com.czy.myoa.domain.Role;
import com.czy.myoa.service.RoleService;

@Service
public class RoleServiceImpl extends BaseDaoImpl<Role> implements RoleService,
		BaseDao<Role> {

}
