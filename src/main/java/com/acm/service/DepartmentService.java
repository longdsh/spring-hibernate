package com.acm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acm.bean.Department;
import com.acm.dao.BaseDao;
import com.acm.dao.DepartmentDao;

/**
* @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
* @version 创建时间：2017年11月2日 上午9:49:41
* 类说明
*/
@Service
public class DepartmentService {
    
	@Resource
	DepartmentDao departmentDao;
	
	//@Transactional
	public void saveDepartment(Department department) {
		departmentDao.save(department);
	}
	
	public Department findDepartmentById(int id) {
		return departmentDao.findById(id);
	}
	
	
}
