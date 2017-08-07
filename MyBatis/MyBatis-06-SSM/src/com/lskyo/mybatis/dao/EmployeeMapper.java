package com.lskyo.mybatis.dao;

import java.util.List;

import com.lskyo.spring.entity.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
	
}
