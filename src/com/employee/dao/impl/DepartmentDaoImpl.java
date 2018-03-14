package com.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;

/**
 * 部门的dao接口的实现类
 * @author Administrator
 * @date 2016年12月24日
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		
		if(list.size()>0){
			return list.get(0).intValue();
		}else{
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByPage(int begin, int pageCount) {
		//通过分离标准方法得到数据
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageCount);
		return list;
	}

	/**
	 * 保存部门
	 */
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	/**
	 * 根据ID查询部门
	 */
	@Override
	public Department editById(Integer did) {
		return this.getHibernateTemplate().get(Department.class,did);
	}

	/**
	 * 修改部门
	 */
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	/**
	 * 删除部门
	 */
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	/**
	 * 查询所有部门
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		String hql = "from Department";
		List<Department> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
}
