package com.czy.myoa.base;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存 实例
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 删除实例
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 更新实例
	 * 
	 * @param entity
	 */
	public void updata(T entity);

	/**
	 * 根据id 获取实例
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Long id);

	/**
	 * 获取实例集合
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

}
