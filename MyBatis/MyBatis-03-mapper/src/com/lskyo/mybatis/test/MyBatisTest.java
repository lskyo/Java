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
 * 1���ӿ�ʽ��� ԭ���� Dao ====> DaoImpl mybatis�� Mapper ====> xxMapper.xml
 * 
 * 2��SqlSession��������ݿ��һ�λỰ���������رգ�
 * 3��SqlSession��connectionһ�������Ƿ��̰߳�ȫ��ÿ��ʹ�ö�Ӧ��ȥ��ȡ�µĶ���
 * 4��mapper�ӿ�û��ʵ���࣬����mybatis��Ϊ����ӿ�����һ��������� �����ӿں�xml���а󶨣� EmployeeMapper
 * empMapper = sqlSession.getMapper(EmployeeMapper.class); 5��������Ҫ�������ļ���
 * mybatis��ȫ�������ļ����������ݿ����ӳ���Ϣ�������������Ϣ��...ϵͳ���л�����Ϣ sqlӳ���ļ���������ÿһ��sql����ӳ����Ϣ��
 * ��sql��ȡ������
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
	 * 1������xml�����ļ���ȫ�������ļ�������һ��SqlSessionFactory���� ������ԴһЩ���л�����Ϣ
	 * 2��sqlӳ���ļ���������ÿһ��sql���Լ�sql�ķ�װ����ȡ� 3����sqlӳ���ļ�ע����ȫ�������ļ��� 4��д���룺
	 * 1��������ȫ�������ļ��õ�SqlSessionFactory��
	 * 2����ʹ��sqlSession��������ȡ��sqlSession����ʹ������ִ����ɾ�Ĳ�
	 * һ��sqlSession���Ǵ�������ݿ��һ�λỰ������ر�
	 * 3����ʹ��sql��Ψһ��־������MyBatisִ���ĸ�sql��sql���Ǳ�����sqlӳ���ļ��еġ�
	 */

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2. ��ȡsqlSessionʵ������ֱ��ִ���Ѿ�ӳ���sql���
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Employee employee = openSession.selectOne("com.lskyo.mybatis.dao.EmployeeMapper.getEmpById", 1);
			System.out.println(employee);

		} finally {
			openSession.close();
		}

	}

	//����ӿڱ��
	@Test
	public void test01() throws IOException {
		// 1����ȡsqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2����ȡsqlSession����
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3����ȡ�ӿڵ�ʵ�������
			// ��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������ȥִ����ɾ�Ĳ鷽��
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		} finally {
			openSession.close();
		}

	}

	//sql�����@Selectע��д�ڽӿ���
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
	 * ������ɾ��
	 * 1��mybatis������ɾ��ֱ�Ӷ����������ͷ���ֵ
	 * 		Integer��Long��Boolean��void
	 * 2��������Ҫ�ֶ��ύ����
	 * 		sqlSessionFactory.openSession();===���ֶ��ύ
	 * 		sqlSessionFactory.openSession(true);===���Զ��ύ
	 */
	@Test
	public void test03() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//1. ��ȡ�� SqlSession �����Զ��ύ����
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//��������
			//Employee employee = new Employee(null, "jerry", "jerry@qq.com", "1");
			//Boolean result = mapper.addEmp(employee);
			
			
			//�����޸�
//			Employee employee = new Employee(4, "Tom", "tom@qq.com", "1");
//			Boolean result = mapper.updateEmp(employee);
			
			//����ɾ��
//			Long result = mapper.deleteEmpById(4);
			
			
//			System.out.println(employee);
//			System.out.println(result);
			//2. �ֶ��ύ����
			openSession.commit();
		}finally {
			openSession.close();
		}

	}
	
	
	/**
	 * ���Դ��������
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
	 * ���Է���List
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
	 * ���Է���Map
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
	 * ����EmployeeMapperPlus , resultMap
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
	 * �������ϲ�ѯ,association
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
	 * ����ʹ��association���зֲ���ѯ
	 * @throws IOException
	 */
	@Test
	public void test09() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpByIdStep(5);
			//�����˰�����غ󣬣�û�õ�������Ϣ�����ѯ��
			System.out.println(employee.getEmail());
			System.out.println(employee.getDept());

		}finally {
			openSession.close();
		}
	}
	
	/**
	 * ����ʹ��collection��ǩ��������ļ������͵����Է�װ����
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
	 * ����discriminator������
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
