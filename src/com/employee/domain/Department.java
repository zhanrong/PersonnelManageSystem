package com.employee.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体类
 * @author Administrator
 * @date 2016年12月24日
 */
public class Department {
	private Integer did;
	private String dname;
	private String ddesc;
	//部门员工的集合
	private Set<Employee> employee = new HashSet<Employee>();
	
	public Integer getDid() {
		return did;
	}
	
	public void setDid(Integer did) {
		this.did = did;
	}
	
	public String getDname() {
		return dname;
	}
	
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getDdesc() {
		return ddesc;
	}
	
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
	public Set<Employee> getEmployee() {
		return employee;
	}
	
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

}
