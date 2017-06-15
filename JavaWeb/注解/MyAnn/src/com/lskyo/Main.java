package com.lskyo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = new Child();
		person.sing();
		
		
		
		Class c = null;
		try {
			c = Class.forName("com.lskyo.Child");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(c.isAnnotationPresent(Description.class)){
			Description d = (Description) c.getAnnotation(Description.class);
			System.out.println(d.value());
		}
		
		/*
		 * 第一种解析方法
		 * 
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(Description.class)){
				Description d = method.getAnnotation(Description.class);
				System.out.println(d.value());
			}
		}
		*/
		
		//第二种解析方法
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				if(annotation instanceof Description){
					System.out.println(((Description) annotation).value());
				}
			}
		}
		
		
		
	}

}
