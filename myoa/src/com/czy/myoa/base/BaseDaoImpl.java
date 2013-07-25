package com.czy.myoa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;

	protected Class<T> clazz;

	public BaseDaoImpl() {
		// ͨ反射 取得 T 的具体类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		System.out.println(" BaseDaoImpl<T>  ----- test clazz =  " + clazz);

	}

	@Override
	public void save(T entity) {
		Session session = getSession();
		session.save(entity);
	}

	@Override
	public void delete(Long id) {
		Session session = getSession();
		Object obj = session.get(clazz, id);
		session.delete(obj);
	}

	@Override
	public void updata(T entity) {
		Session session = getSession();
		session.update(entity);
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		List<T> entityList = getSession()
				.createQuery(
						"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
		return entityList;
	}

	@Override
	public List<T> findAll() {
		List<T> entityList = getSession().createQuery(
				"FROM " + clazz.getSimpleName())//
				.list();
		return entityList;
	}

	/**
	 * 获取当前 session
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
