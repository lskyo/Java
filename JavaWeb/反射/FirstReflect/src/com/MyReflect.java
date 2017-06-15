package com;

public class MyReflect {
	public static void main(String[] args) {

		Class c1 = null;
		try {
			c1 = Class.forName("com.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class c2 = Foo.class;
		Foo foo1 = new Foo(), foo2 = null, foo3 = null;
		Class c3 = foo1.getClass();

		try {
			foo1 = (Foo) c1.newInstance();
			foo2 = (Foo) c2.newInstance();
			foo3 = (Foo) c3.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		foo1.print();

	}
}

class Foo {
	void print() {
		System.out.println("Foo");
	}
}
