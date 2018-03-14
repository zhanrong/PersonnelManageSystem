package com.employee.action;

import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门action
 * @author Administrator
 * @date 2016年12月24日
 */
@SuppressWarnings("serial")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	
	//struts结合spring自动注入的department
	private Department department = new Department();
	
	public Department getModel() {
		return department;
	}
	
	//spring注入departmentService
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//接收当前页面的值
	private int currentPage = 1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	//分页查询部门
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currentPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//通过action返回添加部门的视图
	public String saveUI(){
		return "saveUI";
	}
	
	/**
	 * 保存部门
	 * @return
	 */
	//添加部门的save方法
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	
	/**
	 * 根据ID查询部门
	 * @return
	 */
	public String editById(){
		department = departmentService.editById(department.getDid());
		return "editSuccess";
	}
	
	/**
	 * 修改部门
	 * @return
	 */
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	
	/**
	 * 删除部门
	 * @return
	 */
	public String delete(){
		Department dep = departmentService.editById(department.getDid());
		departmentService.delete(dep);
		return "deleteSuccess";
	}
	
}
