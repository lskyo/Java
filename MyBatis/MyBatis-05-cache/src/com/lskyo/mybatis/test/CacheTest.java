package com.lskyo.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lskyo.mybatis.bean.Department;
import com.lskyo.mybatis.bean.Employee;
import com.lskyo.mybatis.dao.DepartmentMapper;
import com.lskyo.mybatis.dao.EmployeeMapper;

public class CacheTest {


	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * �������棺
	 * һ�����棺�����ػ��棩��sqlSession����Ļ��档һ��������һֱ�����ģ�SqlSession�����һ��Map
	 * 		�����ݿ�ͬһ�λỰ�ڼ��ѯ�������ݻ���ڱ��ػ����С�
	 * 		�Ժ������Ҫ��ȡ��ͬ�����ݣ�ֱ�Ӵӻ������ã�û��Ҫ��ȥ��ѯ���ݿ⣻
	 * 
	 * 		һ������ʧЧ�����û��ʹ�õ���ǰһ������������Ч�����ǣ�����Ҫ�������ݿⷢ����ѯ����
	 * 		1��sqlSession��ͬ��
	 * 		2��sqlSession��ͬ����ѯ������ͬ.(��ǰһ�������л�û���������)
	 * 		3��sqlSession��ͬ�����β�ѯ֮��ִ������ɾ�Ĳ���(�����ɾ�Ŀ��ܶԵ�ǰ������Ӱ��)
	 * 		4��sqlSession��ͬ���ֶ������һ�����棨������գ�
	 * 
	 * �������棺��ȫ�ֻ��棩������namespace����Ļ��棺һ��namespace��Ӧһ���������棺
	 * 		�������ƣ�
	 * 		1��һ���Ự����ѯһ�����ݣ�������ݾͻᱻ���ڵ�ǰ�Ự��һ�������У�
	 * 		2������Ự�رգ�һ�������е����ݻᱻ���浽���������У��µĻỰ��ѯ��Ϣ���Ϳ��Բ��ն��������е����ݣ�
	 * 		3��sqlSession===EmployeeMapper==>Employee
	 * 						DepartmentMapper===>Department
	 * 			��ͬnamespace��������ݻ�����Լ���Ӧ�Ļ����У�map��
	 * 			Ч�������ݻ�Ӷ��������л�ȡ
	 * 				��������ݶ��ᱻĬ���ȷ���һ�������С�
	 * 				ֻ�лỰ�ύ���߹ر��Ժ�һ�������е����ݲŻ�ת�Ƶ�����������
	 * 		ʹ�ã�
	 * 			1��������ȫ�ֶ����������ã�<setting name="cacheEnabled" value="true"/>
	 * 			2����ȥmapper.xml������ʹ�ö������棺
	 * 				<cache></cache>
	 * 			3�������ǵ�POJO��Ҫʵ�����л��ӿ�
	 * 	
	 * �ͻ����йص�����/���ԣ�
	 * 			1����cacheEnabled=true��false���رջ��棨��������رգ�(һ������һֱ���õ�)
	 * 			2����ÿ��select��ǩ����useCache="true"��
	 * 					false����ʹ�û��棨һ��������Ȼʹ�ã��������治ʹ�ã�
	 * 			3������ÿ����ɾ�ı�ǩ�ģ�flushCache="true"����һ�����������������
	 * 					��ɾ��ִ����ɺ�ͻ�������棻
	 * 					���ԣ�flushCache="true"��һ�����������ˣ�����Ҳ�ᱻ�����
	 * 					��ѯ��ǩ��flushCache="false"��
	 * 						���flushCache=true;ÿ�β�ѯ֮�󶼻���ջ��棻������û�б�ʹ�õģ�
	 * 			4����sqlSession.clearCache();ֻ�������ǰsession��һ�����棻
	 * 			5����localCacheScope�����ػ��������򣺣�һ������SESSION������ǰ�Ự���������ݱ����ڻỰ�����У�
	 * 								STATEMENT�����Խ���һ�����棻		
	 * 				
	 * �������������ϣ�
	 *		1���������������������ɣ�
	 *		2����������������������ϵ���������ٷ��У�
	 *		3����mapper.xml��ʹ���Զ��建��
	 *		<cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
	 */
	
	@Test
	public void testFirstLevelCache() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee emp01 = mapper.getEmpById(5);
			System.out.println(emp01);
			
			//xxxxx
			//1��sqlSession��ͬ��
			//SqlSession openSession2 = sqlSessionFactory.openSession();
			//EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
			
			//2��sqlSession��ͬ����ѯ������ͬ
			
			//3��sqlSession��ͬ�����β�ѯ֮��ִ������ɾ�Ĳ���(�����ɾ�Ŀ��ܶԵ�ǰ������Ӱ��)
			//mapper.addEmp(new Employee(null, "testCache", "cache", "1"));
			//System.out.println("������ӳɹ�");
			
			//4��sqlSession��ͬ���ֶ������һ�����棨������գ�
			//openSession.clearCache();
			
			Employee emp02 = mapper.getEmpById(5);
			//Employee emp03 = mapper.getEmpById(3);
			System.out.println(emp02);
			//System.out.println(emp03);
			System.out.println(emp01==emp02);
			
			//openSession2.close();
		}finally{
			openSession.close();
		}
	}
	
	
	
	@Test
	public void testSecondLevelCache() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		try{
			//1��
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
			
			Employee emp01 = mapper.getEmpById(5);
			System.out.println(emp01);
			openSession.close();
			
			//�ڶ��β�ѯ�ǴӶ����������õ������ݣ���û�з����µ�sql
			//mapper2.addEmp(new Employee(null, "aaa", "nnn", "0"));
			Employee emp02 = mapper2.getEmpById(5);
			System.out.println(emp02);
			openSession2.close();
			
		}finally{
			
		}
	}
	
	
	@Test
	public void testSecondLevelCache02() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		try{
			//1��
			DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
			DepartmentMapper mapper2 = openSession2.getMapper(DepartmentMapper.class);
			
			Department deptById = mapper.getDeptById(1);
			System.out.println(deptById);
			openSession.close();
			
			
			
			Department deptById2 = mapper2.getDeptById(1);
			System.out.println(deptById2);
			openSession2.close();
			
		}finally{
			
		}
	}
	
}
