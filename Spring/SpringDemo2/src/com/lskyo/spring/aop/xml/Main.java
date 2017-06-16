package com.lskyo.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//1.����Spring��IOC����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		//2.��IOC�����л�ȡBean��ʵ��
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		
		//3.ʹ��Bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(6, 1);
		System.out.println("result:" + result);
	}

}
