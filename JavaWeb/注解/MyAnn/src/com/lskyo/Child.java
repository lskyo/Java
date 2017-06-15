package com.lskyo;




//@Description("I am child class description...")
public class Child extends Person {

	//@Description("I am name method description...")
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Description("I am age method description...")
	@Override
	public int age() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Description("I am sing method description...")
	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("sing..");
	}

}
