package com.lskyo.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee getById(int id){
		Employee employee = null;
		String sql = "select id, last_name lastName, email from employees where id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return employee;
	}
}
