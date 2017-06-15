package com.lskyo.spring.beans.spel;

public class Car {
	private String brand;
	private double price;
	private double tyrePerimeter;
	
	
	
	
	
	public double getTyrePerimeter() {
		return tyrePerimeter;
	}
	public void setTyrePerimeter(double tyrePerimeter) {
		this.tyrePerimeter = tyrePerimeter;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyrePerimeter=" + tyrePerimeter + "]";
	}
	public Car() {
		// TODO Auto-generated constructor stub
		System.out.println("This is car's constructor...");
	}
	
}
