package com.lskyo.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lskyo.mybatis.bean.Department;
import com.lskyo.mybatis.bean.Employee;
import com.lskyo.mybatis.dao.DepartmentMapper;
import com.lskyo.mybatis.dao.EmployeeMapper;
import com.lskyo.mybatis.dao.EmployeeMapperAnnotation;
import com.lskyo.mybatis.dao.EmployeeMapperPlus;

/**
 * 1、接口式编程 原生： Dao ====> DaoImpl mybatis： Mapper ====> xxMapper.xml
 * 
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。 （将接口和xml进行绑定） EmployeeMapper
 * empMapper = sqlSession.getMapper(EmployeeMapper.class); 5、两个重要的配置文件：
 * mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息 sql映射文件：保存了每一个sql语句的映射信息：
 * 将sql抽取出来。
 * 
 * 
 *
 */

public class MyBatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
	 * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。 3、将sql映射文件注册在全局配置文件中 4、写代码：
	 * 1）、根据全局配置文件得到SqlSessionFactory；
	 * 2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
	 * 一个sqlSession就是代表和数据库的一次会话，用完关闭
	 * 3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
	 */

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2. 获取sqlSession实例，能直接执行已经映射的sql语句
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Employee employee = openSession.selectOne("com.lskyo.mybatis.dao.EmployeeMapper.getEmpById", 1);
			System.out.println(employee);

		} finally {
			openSession.close();
		}

	}

	//面向接口编程
	@Test
	public void test01() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3、获取接口的实现类对象
			// 会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		} finally {
			openSession.close();
		}

	}

	//sql语句用@Select注解写在接口上
	@Test
	public void test02() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		} finally {
			openSession.close();
		}

	}
	
	
	/**
	 * 测试增删改
	 * 1、mybatis允许增删改直接定义以下类型返回值
	 * 		Integer、Long、Boolean、void
	 * 2、我们需要手动提交数据
	 * 		sqlSessionFactory.openSession();===》手动提交
	 * 		sqlSessionFactory.openSession(true);===》自动提交
	 */
	@Test
	public void test03() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//1. 获取的 SqlSession 不会自动提交数据
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//测试增加
			//Employee employee = new Employee(null, "jerry", "jerry@qq.com", "1");
			//Boolean result = mapper.addEmp(employee);
			
			
			//测试修改
//			Employee employee = new Employee(4, "Tom", "tom@qq.com", "1");
//			Boolean result = mapper.updateEmp(employee);
			
			//测试删除
//			Long result = mapper.deleteEmpById(4);
			
			
//			System.out.println(employee);
//			System.out.println(result);
			//2. 手动提交数据
			openSession.commit();
		}finally {
			openSession.close();
		}

	}
	
	
	/**
	 * 测试传多个参数
	 * @throws IOException
	 */
	@Test
	public void test04() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
//			Employee employee = mapper.getEmpByIdAndLastName(5, "jerry");
			Map<String, Object> map = new HashMap<>();
			map.put("id", 5);
			map.put("lastName", "jerry");
			map.put("tableName", "tbl_employee");
			Employee employee = mapper.getEmpByMap(map);
			
			
			
			System.out.println(employee);
		}finally {
			openSession.close();
		}

	}
	
	
	/**
	 * 测试返回List
	 * @throws IOException
	 */
	@Test
	public void test05() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			List<Employee> list = mapper.getEmpsByLastNameLike("%e%");
			for (Employee employee : list) {
				
				System.out.println(employee);
			}
		}finally {
			openSession.close();
		}

	}
	/**
	 * 测试返回Map
	 * @throws IOException
	 */
	@Test
	public void test06() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//Map<String, Object> map = mapper.getEmpByIdReturnMap(5);
			Map<Integer, Employee> map = mapper.getEmpsByLastNameLikeReturnMap("%r%");
			System.out.println(map);
		}finally {
			openSession.close();
		}

	}
	
	
	/**
	 * 测试EmployeeMapperPlus , resultMap
	 * @throws IOException
	 */
	@Test
	public void test07() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpById(5);
			System.out.println(employee);
			
		}finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试联合查询,association
	 * @throws IOException
	 */
	@Test
	public void test08() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpAndDept(5);
			System.out.println(employee);
			
			
			
		}finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试使用association进行分步查询
	 * @throws IOException
	 */
	@Test
	public void test09() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpByIdStep(5);
			//开启了按需加载后，，没用到部门信息不会查询；
			System.out.println(employee.getEmail());
			System.out.println(employee.getDept());

		}finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试使用collection标签定义关联的集合类型的属性封装规则
	 * @throws IOException
	 */
	@Test
	public void test10() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
			//Department department = mapper.getDeptByIdPlus(2);
			Department department = mapper.getDeptByIdStep(2);
			System.out.println(department.getDepartmentName());
			System.out.println(department.getEmps());

		}finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试discriminator鉴别器
	 * @throws IOException
	 */
	@Test
	public void test11() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
			//Department department = mapper.getDeptByIdPlus(2);
			Employee employee = mapper.getEmpById(5);
			System.out.println(employee);
			employee = mapper.getEmpById(6);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
