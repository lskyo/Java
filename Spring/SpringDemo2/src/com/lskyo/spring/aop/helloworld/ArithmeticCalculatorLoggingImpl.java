package com.lskyo.spring.aop.helloworld;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("add[" + i + "," + j + "]");
		int result = i + j;
		System.out.println("result = " + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("sub[" + i + "," + j + "]");
		int result = i - j;
		System.out.println("result = " + result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("mul[" + i + "," + j + "]");
		int result = i * j;
		System.out.println("result = " + result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("div[" + i + "," + j + "]");
		int result = i / j;
		System.out.println("result = " + result);
		return result;
	}

}
