package com.employee.domain;

import java.util.Date;

/**
 * 员工实体
 * @author Administrator
 * @date 2016年12月24日
 */
public class Employee {
	private Integer eid;
	private String ename;
	private String sex;
	private Date birthday;
	private Date joinDay;
	private String eno;
	private String username;
	private String password;
	//员工的所属部门
	private Department department;
	
	public Integer getEid() {
		return eid;
	}
	
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getJoinDay() {
		return joinDay;
	}
	
	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}
	public String getEno() {
		return eno;
	}
	
	public void setEno(String eno) {
		this.eno = eno;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
