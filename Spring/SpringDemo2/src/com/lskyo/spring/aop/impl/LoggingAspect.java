package com.lskyo.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lskyo 
 * �����������Ϊ���棺��Ҫ�Ѹ������IOC������(@Component)��������Ϊ����(@Aspect),@Order���Ծ����������ȼ�
 */
@Order(0)
@Aspect
@Component
public class LoggingAspect {

	
	/**
	 * ����һ�����������������������ʽ��һ��ģ��÷����в���Ҫ�������������롣
	 * ʹ��@Pointcut �������������ʽ��
	 * ���������ֱ֪ͨ�����÷�������ʹ���������ʽ��
	 */
	@Pointcut("execution(public int com.lskyo.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression(){}
	
	
	 //�����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 @Before("declareJoinPointExpression()")
	 public void beforeMethod(JoinPoint joinPoint){
	 String methodName = joinPoint.getSignature().getName();
	 List<Object> args = Arrays.asList(joinPoint.getArgs());
	 System.out.println("---------- " + methodName + " method begain ----------");
	 //System.out.println(methodName + args);
	 }
	
	
	 //����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣���÷���ִ��
	 //�ں���֪ͨ�в��ܷ���Ŀ�귽����ִ�н��
	 @After("declareJoinPointExpression()")
	 public void afterMethod(JoinPoint joinPoint){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println("---------- " + methodName + " method end ----------");
	 }
	
	 //����֪ͨ���ڷ�����������֮��ִ�еĴ���
	 //�ڷ���֪ͨ���ǿ��Է��ʷ��ؽ����
	 @AfterReturning(value="declareJoinPointExpression()", returning="result")
	 public void afterReturning(JoinPoint joinPoint, Object result){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println(methodName + " result:" + result);
	 }
	
	 //�쳣֪ͨ���ڷ����׳��쳣��ִ��
	 //����ָ���ض��쳣��ִ��
	 @AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	 public void afterThrowing(JoinPoint joinPoint, Exception ex){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println(methodName + " occurs excetion:" + ex);
	 }

	/*
	//����֪ͨ����������
	@Around("execution(public int com.lskyo.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		Object result = null;
		try {
			System.out.println(methodName + Arrays.asList(args));
			result = pjp.proceed();   //ִ��Ŀ�귽��
			System.out.println("---->" + result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	*/
}
