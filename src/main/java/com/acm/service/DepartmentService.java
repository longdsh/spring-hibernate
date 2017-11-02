package com.acm.service;

import com.acm.bean.Department;

/**
* @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
* @version 创建时间：2017年11月2日 下午1:42:08
* 类说明
*/
public interface DepartmentService {
	
     public void saveDepartment(Department department);
     public Department getDepartmentById(int id);
     public void updateDepartment(Department department);
     public void deleteDepartmentById(int id);
}
