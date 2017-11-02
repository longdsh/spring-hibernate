package com.acm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acm.bean.Department;
import com.acm.dao.impl.BaseDaoImpl;
import com.acm.dao.impl.DepartmentDaoImpl;
import com.acm.service.DepartmentService;

/**
* @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
* @version 创建时间：2017年11月2日 上午9:49:41
* 类说明
*/
@Service
public class DepartmentServiceImpl implements DepartmentService{
    
	@Resource
	DepartmentDaoImpl departmentDao;
	
	
	public void saveDepartment(Department department) {
		departmentDao.save(department);
	}
	
	public Department getDepartmentById(int id) {
		return departmentDao.getById(id);
	}


	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
		
	}

	@Override
	public void deleteDepartmentById(int id) {
		// TODO Auto-generated method stub
		departmentDao.delete(id);
		
	}
	
	
	
	
}
