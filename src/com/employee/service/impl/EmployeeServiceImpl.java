package com.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.EmployeeService;

/**
 * 员工管理的service接口的实现类
 * @author Administrator
 * @date 2016年12月24日
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	//使用spring注入的dao
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/**
	 * 业务层的登录的执行方法
	 * @param employee
	 * @return
	 */
	@Override
	public Employee findUserExist(Employee employee) {
		return employeeDao.findUserExist(employee);
	}
	
	/**
	 * 分页查询员工
	 */
	@Override
	public PageBean<Employee> findAll(int currentPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		// 封装当前页数
		pageBean.setCurrentPage(currentPage);
		// 封装每页显示记录数
		int pageCount = 3;
		pageBean.setPageCount(pageCount);
		// 封装总记录数
		int totalSize = employeeDao.findCount();
		pageBean.setTotalSize(totalSize);
		// 封装总页数
		double ts = totalSize;
		Double num = Math.ceil(ts / pageCount);
		pageBean.setPageSize(num.intValue());
		// 封装每页显示的数据
		int begin = (currentPage - 1) * pageCount;
		// 这个方法用于查找出指定页数中的List<Employee>
		List<Employee> list = employeeDao.findAll(begin,pageCount);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 保存员工
	 */
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}
	
	/**
	 * 编辑员工
	 */
	@Override
	public Employee edit(Integer eid) {
		return employeeDao.edit(eid);
	}
	
	/**
	 * 修改员工
	 */
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	/**
	 * 删除员工
	 */
	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

}
