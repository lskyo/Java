package com.lskyo.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {

	@Before("com.lskyo.spring.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("---->Args:" + Arrays.asList(joinPoint.getArgs()));
	}
}
