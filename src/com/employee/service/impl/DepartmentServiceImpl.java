package com.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 部门的service接口的实现类
 * @author Administrator
 * @date 2016年12月24日
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	//spring注入部门的departmentDaoImpl
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	/**
	 * 分页查询部门方法
	 */
	@Override
	public PageBean<Department> findByPage(int currentPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrentPage(currentPage);
		//封装每页显示记录数
		int pageCount = 3;
		pageBean.setPageCount(pageCount);
		//封装总记录数
		int totalSize = departmentDao.findCount();
		pageBean.setTotalSize(totalSize);
		//封装总页数
		double ts = totalSize;
		Double num = Math.ceil(ts /  pageCount);
		pageBean.setPageSize(num.intValue());
		//封装每页显示的数据
		int begin = (currentPage - 1) * pageCount;
		List<Department> list = departmentDao.findByPage(begin,pageCount);
		pageBean.setList(list);
		ActionContext.getContext().put("list", list);
		return pageBean;
	}
	
	/**
	 * 保存部门
	 */
	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}
	
	/**
	 * 根据ID查询部门
	 */
	@Override
	public Department editById(Integer did) {
		return departmentDao.editById(did);
	}
	
	/**
	 * 修改部门
	 */
	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}
	
	/**
	 * 删除部门
	 */
	@Override
	public void delete(Department dep) {
		departmentDao.delete(dep);
	}
	
	/**
	 * 查询所有部门
	 */
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
}
