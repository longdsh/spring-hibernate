package com.acm.dao.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acm.bean.Department;
import com.acm.dao.BaseDao;
import com.acm.util.ReflectionUtils;

/**
 * @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
 * @version 创建时间：2017年11月2日 上午8:23:46 类说明
 */
@Repository
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz = null;

	public BaseDaoImpl() {// 反射
		//this表示的是new的那个类 即 BaseDao的子类
		clazz = ReflectionUtils.getSuperGenericType(this.getClass());
	}

	// @Transactional
	public void save(T entity) {

		getSession().save(entity);

	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
		
	}

	@Override
	public T getById(int id) {
		// TODO Auto-generated method stub
		System.out.println(clazz);
		return getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		if (ids == null || ids.size() == 0) {
			return Collections.EMPTY_LIST;
		}

		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
