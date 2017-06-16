package com.lskyo.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class ValidationAspect {

	public void validateArgs(JoinPoint joinPoint){
		System.out.println("---->Args:" + Arrays.asList(joinPoint.getArgs()));
	}
}
