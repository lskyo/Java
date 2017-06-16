package com.lskyo.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ʵ��������������Ҫ�������������ٵ��ù�����ʵ������������Bean
 */
public class InstanceCarFactory {
	
	private Map<String, Car> cars;
	
	public InstanceCarFactory(){
		cars = new HashMap<String, Car>();
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 400000));
	}
	
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
