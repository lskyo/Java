package com.lskyo.spring.jdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private EmployeeDao employeeDao = null;
	private DepartmentDao departmentDao = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
	
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
		departmentDao = ctx.getBean(DepartmentDao.class);
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	
	
	/**
	 * 使用具名参数时，可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
	 * 1. SQL 语句中的参数民和类的属性名必须一致！
	 * 2. 使用 SqlParameterSource 的实现类 BeanPropertySqlParameterSource 作为参数。
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "INSERT INTO employees(last_name,email,dept_id) "
				+ "VALUES(:lastName,:email,:deptId)";
		
		Employee employee = new Employee();
		employee.setLastName("Jack");
		employee.setEmail("jack@sina.com");
		employee.setDeptId(3);
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	
	/**
	 * 可以为参数起名字
	 * 好处： 若有多个参数，不用对应位置，直接对参数名，便于维护
	 * 坏处： 较为麻烦
	 */
	//@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:ln,:email,:deptid)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ln", "FF");
		paramMap.put("email", "ff@111.com");
		paramMap.put("deptid", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	
	//@Test
	public void testDepartmentDao(){
		System.out.println(departmentDao.getById(1));
	}
	
	
	
	//@Test
	public void testEmployeeDao(){
		Employee employee = employeeDao.getById(2);
		System.out.println(employee);
	}
	
	
	/**
	 * 获取单个列，或统计查询
	 */
	//@Test
	public void testQueryForObject2(){
		String sql = "select count(id) from employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	
	
	/**
	 * 查询实体类的集合，注意调用的不是 queryForList 方法
	 */
	//@Test
	public void testQueryForList(){
		String sql = "select id, last_name lastName, email from employees where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List list = jdbcTemplate.query(sql, rowMapper, 5);
		System.out.println(list);
	}
	
	
	/**
	 * 从数据库中获取一条记录，实际获得对应的一个对象
	 * 1. 其中的 RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
	 * 2. 使用 SQL 中列的别名完成列明和类的属性名之间的映射，例如 last_name lastName
	 * 3. 不支持级联属性，JdbcTemplate 到底是一个 JDBC 的小工具，而不是 ORM 框架
	 */
	//@Test
	public void testQueryForObject(){
		String sql = "select id, last_name lastName, email, dept_id as \"department.id\" from employees where id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}
	
	
	
	/**
	 * 批量更新
	 */
	//@Test
	public void testBatchUpdate(){
		String sql = "insert into employees(last_name, email, dept_id) values(?,?,?)";
		
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		
		batchArgs.add(new Object[]{"AA","aa@163.com",1});
		batchArgs.add(new Object[]{"BB","bb@163.com",2});
		batchArgs.add(new Object[]{"CC","cc@163.com",3});
		batchArgs.add(new Object[]{"DD","dd@163.com",4});
		batchArgs.add(new Object[]{"EE","ee@163.com",3});
		batchArgs.add(new Object[]{"GG","gg@163.com",2});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	
	
	//@Test
	public void testUpdate(){
		String sql = "update employees set email=? where id=?";
		jdbcTemplate.update(sql, "abc@163.com", 5);
	}
	
	
	//@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
