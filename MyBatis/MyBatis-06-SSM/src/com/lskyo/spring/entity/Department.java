package com.lskyo.spring.entity;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String departmentName;
	private List<Employee> emps;
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}
	public Department(Integer id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	public Department() {
		super();
	}
	public Department(Integer id) {
		super();
		this.id = id;
	}
	
	
	
}
