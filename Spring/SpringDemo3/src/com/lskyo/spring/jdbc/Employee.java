package com.lskyo.spring.jdbc;

public class Employee {
	
	private int id;
	private String lastName;
	private String email;
	private int deptId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", deptId=" + deptId + "]";
	}

	
}
