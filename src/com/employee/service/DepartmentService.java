package com.employee.service;

import java.util.List;

import com.employee.domain.Department;
import com.employee.domain.PageBean;

/**
 * 部门管理的service接口
 * @author Administrator
 * @date 2016年12月24日
 */
public interface DepartmentService {
	
	PageBean<Department> findByPage(int currentPage);
	
	void save(Department department);
	
	Department editById(Integer did);
	
	void update(Department department);
	
	void delete(Department department);
	
	List<Department> findAll();
	
}
