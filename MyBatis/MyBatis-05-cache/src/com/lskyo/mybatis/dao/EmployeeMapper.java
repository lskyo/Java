package com.lskyo.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.lskyo.mybatis.bean.Employee;

public interface EmployeeMapper {

	@MapKey("id")//告诉MyBatis封装这个map的时候用id属性做key
	public Map<Integer, Employee> getEmpsByLastNameLikeReturnMap(String lastName);
	
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	
	public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);
	
	public Employee getEmpById(Integer id);
	
	public Boolean addEmp(Employee employee);
	
	public Boolean updateEmp(Employee employee);
	
	public Long deleteEmpById(Integer id);
	
	
}
