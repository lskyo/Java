package com.lskyo.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//1.创建Spring的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		//2.从IOC容器中获取Bean的实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		
		//3.使用Bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(6, 1);
		System.out.println("result:" + result);
	}

}
