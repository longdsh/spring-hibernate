package com.acm.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acm.bean.Department;
import com.acm.dao.BaseDao;
import com.acm.service.DepartmentService;

/**
* @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
* @version 创建时间：2017年11月2日 上午8:20:28
* 类说明
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-*.xml" })//导入 junit4 和springtest
public class test {

   
	
	@Resource
	BaseDao<Department> baseDao;
	@Resource
	DepartmentService departmentService;
	@Resource
	SessionFactory sessionFactory;
	//private ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
	@Test
	public void test() {
		/*System.out.println(baseDao.getSessionFactory());
		System.out.println(baseDao);
		Session session = baseDao.getSession();
		
		System.out.println(session);*/
		//SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		//System.out.println(sessionFactory);
		Department department = new Department();
		department.setName("a");
		Department department1 = new Department();
		department1.setName("b");
		Department department2 = new Department();
		department2.setName("c");
		department1.setFather(department);
		Set<Department> departments = new HashSet<>();
		departments.add(department2);
		department1.setChildren(departments);
		//baseDao.save(department1);
		departmentService.save(department1);
		
		/*Session session = sessionFactory.getCurrentSession();
		
		
		//需要加事务才能运行
		 Transaction trans=session.beginTransaction();	
		 session.save(department1);
		 trans.commit();*/
		
		
		
	}

}
