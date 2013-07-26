package com.czy.myoa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.czy.myoa.base.BaseDaoImpl;
import com.czy.myoa.domain.Forum;
import com.czy.myoa.service.ForumService;

@Service
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements
		ForumService {

	@Override
	public void save(Forum forum) {
		getSession().save(forum);
		forum.setPosition(forum.getId().intValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery(//
				"FROM Forum f ORDER BY f.position ASC")//
				.list();
	}

	public void moveUp(Long id) {
		Forum forum = getById(id);
		Forum other = (Forum) getSession().createQuery(// 我上面那个 Forum
				"FROM Forum f WHERE f.position<? ORDER BY f.position DESC")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		if (other == null) {
			return;
		}
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 更新到数据库中
		// 因为是持久化状态，所以不需要调用update()方法。
	}

	public void moveDown(Long id) {
		Forum forum = getById(id);
		Forum other = (Forum) getSession().createQuery(// 我下面那个 Forum
				"FROM Forum f WHERE f.position>? ORDER BY f.position ASC")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		if (other == null) {
			return;
		}
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 更新到数据库中
		// 因为是持久化状态，所以不需要调用update()方法。
	}

}
