package com.lskyo.spring.beans;

public class HelloWorld {
	
	private String name;
	
	public void setName(String name) {
		System.out.println("setName:" + name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void hello(){
		System.out.println("Hello: " + name);
	}
	
	public HelloWorld() {
		System.out.println("HelloWorld's constructor...");
	}
}
