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
 * 把这个类声明为切面：需要把该类放入IOC容器中(@Component)、再声明为切面(@Aspect),@Order可以决定切面优先级
 */
@Order(0)
@Aspect
@Component
public class LoggingAspect {

	
	/**
	 * 定义一个方法，用于声明切入点表达式，一般的，该方法中不需要再添入其他代码。
	 * 使用@Pointcut 来声明切入点表达式。
	 * 后面的其他通知直接引用方法名来使用切入点表达式。
	 */
	@Pointcut("execution(public int com.lskyo.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression(){}
	
	
	 //声明该方法是一个前置通知：在目标方法开始之前执行
	 @Before("declareJoinPointExpression()")
	 public void beforeMethod(JoinPoint joinPoint){
	 String methodName = joinPoint.getSignature().getName();
	 List<Object> args = Arrays.asList(joinPoint.getArgs());
	 System.out.println("---------- " + methodName + " method begain ----------");
	 //System.out.println(methodName + args);
	 }
	
	
	 //后置通知：在目标方法执行后，无论是否发生异常，该方法执行
	 //在后置通知中不能访问目标方法的执行结果
	 @After("declareJoinPointExpression()")
	 public void afterMethod(JoinPoint joinPoint){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println("---------- " + methodName + " method end ----------");
	 }
	
	 //返回通知：在方法正常结束之后执行的代码
	 //在返回通知中是可以访问返回结果的
	 @AfterReturning(value="declareJoinPointExpression()", returning="result")
	 public void afterReturning(JoinPoint joinPoint, Object result){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println(methodName + " result:" + result);
	 }
	
	 //异常通知：在方法抛出异常后执行
	 //可以指定特定异常后执行
	 @AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	 public void afterThrowing(JoinPoint joinPoint, Exception ex){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println(methodName + " occurs excetion:" + ex);
	 }

	/*
	//环绕通知：并不常用
	@Around("execution(public int com.lskyo.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		Object result = null;
		try {
			System.out.println(methodName + Arrays.asList(args));
			result = pjp.proceed();   //执行目标方法
			System.out.println("---->" + result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	*/
}
