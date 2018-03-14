package com.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;

/**
 * 员工管理的dao接口的实现类
 * @author Administrator
 * @date 2016年12月24日
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	
	/**
	 * 查询用户名和密码是否存在
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Employee findUserExist(Employee employee) {
		String hql = " from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查询总记录数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 分页查询员工
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll(int begin, int pageCount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
		return list;
	}

	/**
	 * 保存员工
	 */
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	/**
	 * 编辑员工
	 */
	@Override
	public Employee edit(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	/**
	 * 修改员工
	 */
	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	/**
	 * 删除员工
	 */
	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

}
