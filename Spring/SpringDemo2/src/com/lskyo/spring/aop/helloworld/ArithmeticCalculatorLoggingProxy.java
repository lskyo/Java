package com.lskyo.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	//Ҫ����Ķ���
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy = null;
		
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		
		//����������ͣ�����������Щ����
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		
		//�����ô���������еķ���ʱ��ִ�иô���
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy�����ڷ��ص��Ǹ��������һ���������invoke�в�ʹ�øö���
			 * method�����ڱ����õķ���
			 * args�����÷���ʱ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.print(method.getName() + Arrays.asList(args));
				Object result = method.invoke(target, args);
				System.out.println(" result:" + result);
				return result;
			}
		};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
