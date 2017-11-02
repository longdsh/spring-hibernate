package com.acm.bean;

import java.util.Set;

/**
* @author 计算机网络应用 路素飞 E-mail:2512977541@qq.com
* @version 创建时间：2017年11月2日 上午8:19:00
* 类说明
*/
public class Department {
	private int id;
	private String name;
	private Department father;
	private Set<Department> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Department getFather() {
		return father;
	}
	public void setFather(Department father) {
		this.father = father;
	}
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
	public Department() {
		super();
	}
	

}
