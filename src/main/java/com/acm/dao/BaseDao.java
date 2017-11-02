package com.acm.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acm.bean.Department;
import com.acm.util.ReflectionUtils;

/**
 * @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
 * @version 创建时间：2017年11月2日 上午8:23:46 类说明
 */
@Repository
public class BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz = null;

	public BaseDao() {// 反射
		//this表示的是new的那个类 即 BaseDao的子类
		clazz = ReflectionUtils.getSuperGenericType(this.getClass());
	}

	// @Transactional
	public void save(T entity) {

		getSession().save(entity);

	}

	public T findById(int id) {
		System.out.println(clazz);
		return getSession().get(clazz, id);
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
