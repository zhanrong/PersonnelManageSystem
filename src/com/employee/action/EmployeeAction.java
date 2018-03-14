package com.employee.action;

import java.util.List;

import com.employee.domain.Department;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理的Action类
 * @author Administrator
 * @date 2016年12月24日
 */
@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	//是struts与spring融合后自动注入的
	private Employee employee = new Employee();
		
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//使用spring将service注入
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//spring注入部门管理的service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//获取当前页
	private int currentPage=1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * 登录执行的方法
	 * @return
	 */
	public String login(){
		//调用业务层的类
		Employee exsitEmploy = employeeService.findUserExist(employee);
		if(exsitEmploy == null){
			//登录失败
			this.addActionError("用户名或者密码错误！");
			return INPUT;
		}else{
			//登录成功
			//把用户信息保存在Session域中
			ActionContext.getContext().getSession().put("exsitEmploy",exsitEmploy);
			return SUCCESS;
		}
	}
	
	/**
	 * 分页查询员工
	 * @return
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加员工页面
	 * @return
	 */
	public String saveUI(){
		//用于查询出所有的部门信息
		List<Department> list = departmentService.findAll();
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	
	/**
	 * 保存员工
	 * @return
	 */
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	/**
	 * 编辑员工
	 * @return
	 */
	public String edit(){
		employee = employeeService.edit(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	
	/**
	 * 修改员工
	 * @return
	 */
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/**
	 * 删除员工
	 * @return
	 */
	public String delete(){
		Employee emp = employeeService.edit(employee.getEid());
		employeeService.delete(emp);
		return "deleteSuccess";
	}
	
	/**
	 * 注册用户
	 * @return
	 */
	public String register(){
		try{
		employeeService.save(employee);
		}catch(Exception e){
			return "registerFalse";
		}finally{
		
		}
		return "registerSuccess";
	}
	
}
