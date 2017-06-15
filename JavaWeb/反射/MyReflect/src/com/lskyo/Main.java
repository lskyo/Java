package com.lskyo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
//		String str = "HelloWorld!";
//		ClassUtil.printClassMessage(str);
//		int i = 6;
//		ClassUtil.printClassMessage(i);
		
		Class c = null;
		try {
			c = Class.forName("com.lskyo.A");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		A a = new A();
		System.out.println(c.getName());
		Method m1 = null,m2 = null,m3 = null;
		try {
			m1 = c.getMethod("print");
			m2 = c.getMethod("print",int.class,int.class);
			m3 = c.getMethod("print",String.class,String.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			m1.invoke(a);
			m2.invoke(a, 20, 20);
			m3.invoke(a, "Hello", "World!");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}


class A{
	public void print(){
		System.out.println("public void print();");
	}
	public void print(int a, int b){
		System.out.println("public void print(int a, int b);");
		System.out.println("a + b = " + (a + b));
	}
	public void print(String a, String b){
		System.out.println("public void print(String a, String b);");
		System.out.println("a + b = " + (a + b));
	}
	
}