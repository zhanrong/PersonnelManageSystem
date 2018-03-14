package com.employee.dao;

import java.util.List;

import com.employee.domain.Employee;

/**
 * 员工管理的dao接口
 * @author Administrator
 * @date 2016年12月24日
 */
public interface EmployeeDao {
	
	Employee findUserExist(Employee employee);
	
	int findCount();
	
	List<Employee> findAll(int begin, int pageSize);

	void save(Employee employee);

	Employee edit(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
