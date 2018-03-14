package com.employee.service;

import com.employee.domain.Employee;
import com.employee.domain.PageBean;

/**
 * 员工管理的service接口
 * @author Administrator
 * @date 2016年12月24日
 */
public interface EmployeeService {
	
	Employee findUserExist(Employee employee);
	
	PageBean<Employee> findAll(int currentPage);
	
	void save(Employee employee);
	
	Employee edit(Integer eid);
	
	void update(Employee employee);

	void delete(Employee employee); 

}
