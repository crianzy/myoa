package com.czy.myoa.service;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.domain.Forum;

public interface ForumService extends BaseDao<Forum>{
	public void moveUp(Long id) ;
	public void moveDown(Long id) ;
}
