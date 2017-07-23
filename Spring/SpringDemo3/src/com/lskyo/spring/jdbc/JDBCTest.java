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
	 * ʹ�þ�������ʱ������ʹ�� update(String sql, SqlParameterSource paramSource) �������и��²���
	 * 1. SQL ����еĲ�������������������һ�£�
	 * 2. ʹ�� SqlParameterSource ��ʵ���� BeanPropertySqlParameterSource ��Ϊ������
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
	 * ����Ϊ����������
	 * �ô��� ���ж�����������ö�Ӧλ�ã�ֱ�ӶԲ�����������ά��
	 * ������ ��Ϊ�鷳
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
	 * ��ȡ�����У���ͳ�Ʋ�ѯ
	 */
	//@Test
	public void testQueryForObject2(){
		String sql = "select count(id) from employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	
	
	/**
	 * ��ѯʵ����ļ��ϣ�ע����õĲ��� queryForList ����
	 */
	//@Test
	public void testQueryForList(){
		String sql = "select id, last_name lastName, email from employees where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List list = jdbcTemplate.query(sql, rowMapper, 5);
		System.out.println(list);
	}
	
	
	/**
	 * �����ݿ��л�ȡһ����¼��ʵ�ʻ�ö�Ӧ��һ������
	 * 1. ���е� RowMapper ָ�����ȥӳ���������У����õ�ʵ����Ϊ BeanPropertyRowMapper
	 * 2. ʹ�� SQL ���еı���������������������֮���ӳ�䣬���� last_name lastName
	 * 3. ��֧�ּ������ԣ�JdbcTemplate ������һ�� JDBC ��С���ߣ������� ORM ���
	 */
	//@Test
	public void testQueryForObject(){
		String sql = "select id, last_name lastName, email, dept_id as \"department.id\" from employees where id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}
	
	
	
	/**
	 * ��������
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
