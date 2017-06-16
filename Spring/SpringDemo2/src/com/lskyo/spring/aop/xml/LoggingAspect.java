package com.lskyo.spring.aop.xml;

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

public class LoggingAspect {

	
	public void declareJoinPointExpression(){}
	
	
	 public void beforeMethod(JoinPoint joinPoint){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println("---------- " + methodName + " method begain ----------");
	 }
	
	
	 public void afterMethod(JoinPoint joinPoint){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println("---------- " + methodName + " method end ----------");
	 }
	
	 public void afterReturning(JoinPoint joinPoint, Object result){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println(methodName + " result:" + result);
	 }
	
	 public void afterThrowing(JoinPoint joinPoint, Exception ex){
	 String methodName = joinPoint.getSignature().getName();
	 System.out.println(methodName + " occurs excetion:" + ex);
	 }

	
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
	
}
