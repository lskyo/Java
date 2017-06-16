package com.lskyo.spring.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println("use bean:" + car);
		
		ctx.close();
	}
}
