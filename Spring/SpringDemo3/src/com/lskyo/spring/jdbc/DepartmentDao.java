package com.lskyo.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



/**
 * 不推荐使用 JdbcDaoSupport
 * @author lskyo
 *
 */
@Repository
public class DepartmentDao extends JdbcDaoSupport {

	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public Department getById(int id){
		String sql = "SELECT id,dept_name name FROM departments WHERE id = ?";
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}
}
