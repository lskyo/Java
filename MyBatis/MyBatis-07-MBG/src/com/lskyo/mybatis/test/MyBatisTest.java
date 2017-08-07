package com.lskyo.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.lskyo.mybatis.bean.Employee;
import com.lskyo.mybatis.bean.EmployeeExample;
import com.lskyo.mybatis.bean.EmployeeExample.Criteria;
import com.lskyo.mybatis.dao.EmployeeMapper;





public class MyBatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMbg() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	
	@Test
	public void testMyBatis3Simple() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			List<Employee> list = mapper.selectByExample(null);
			for (Employee employee : list) {
				System.out.println(employee);
			}
		}finally {
			openSession.close();
		}
	}
	
	@Test
	public void testMyBatis3() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			/* 查询所有员工
			List<Employee> emps = mapper.selectByExample(null);
			for (Employee employee : emps) {
				System.out.println(employee);
			}*/
			
			//select id, last_name, gender, email, d_id from tbl_employee 
			//WHERE ( d_id = ? and gender = ? )
			EmployeeExample example = new EmployeeExample();
			Criteria criteria = example.createCriteria();
			criteria.andDIdEqualTo(2);
			criteria.andGenderEqualTo("0");
			
			
			//select id, last_name, gender, email, d_id from tbl_employee 
			//WHERE ( d_id = ? and gender = ? ) or( email like ? )
			Criteria criteria2 = example.createCriteria();
			criteria2.andEmailLike("%r%");
			example.or(criteria2);
			
			List<Employee> list = mapper.selectByExample(example );
			for (Employee employee : list) {
				System.out.println(employee.getLastName());
			}
		}finally {
			openSession.close();
		}
	}

}
