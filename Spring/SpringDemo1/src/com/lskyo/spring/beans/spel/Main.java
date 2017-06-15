package com.lskyo.spring.beans.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-spel.xml");
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
	}

}
