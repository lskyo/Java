package com.lskyo.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		HelloWorld helloWorld = new HelloWorld();
//		helloWorld.setName("lskyo");
//		helloWorld.hello();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		car = (Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2);
	}

}
