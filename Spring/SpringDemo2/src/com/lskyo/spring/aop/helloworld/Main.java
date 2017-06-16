package com.lskyo.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator = null;
//		arithmeticCalculator = new ArithmeticCalculatorImpl();

		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		int result = proxy.add(1, 3);
		System.out.println("--->" + result);
		result = proxy.div(4, 2);
		System.out.println("--->" + result);
	}

}
