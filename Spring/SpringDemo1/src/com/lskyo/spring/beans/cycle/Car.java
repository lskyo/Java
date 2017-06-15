package com.lskyo.spring.beans.cycle;

public class Car {
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("Car's setBrand ....");
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

	public Car() {
		super();
		System.out.println("Car's constructor ....");
	}
	
	public void init() {
		System.out.println("Car's init ....");

	}
	public void destroy() {
		System.out.println("Car's destroy ....");

	}
}
