package com.acm.dao;

import java.util.List;

/**
* @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
* @version 创建时间：2017年11月2日 下午1:29:57
* 类说明
*/
public interface BaseDao<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 查询实体，如果id为null，则返回null，并不会抛异常。
	 * 
	 * @param id
	 * @return
	 */
	T getById(int id);

	/**
	 * 查询实体
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(List<Integer> ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();


}
