package com.lskyo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	public static void printClassMessage(Object obj){
		Class c = obj.getClass();
		System.out.println("---------------" + c.getName() + "---------------");
		
		System.out.println("以下是构造方法：");
		Constructor[] constructors = c.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			Class[] paramTypes = constructor.getParameterTypes();
			System.out.print(constructor.getName() + "(");
			if(paramTypes != null){
				for (int i = 0; i < paramTypes.length; i++) {
					if(0 == i){
						System.out.print(paramTypes[i].getSimpleName());
					}else{
						System.out.print(", " + paramTypes[i].getSimpleName());
					}
				}
			}
			System.out.println(");");
		}
		
		
		
		
		
		System.out.println("以下是成员变量：");
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			Class fieldType = field.getType();
			String typeName = fieldType.getSimpleName();
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName + ";");
		}
		
		

		System.out.println("以下是成员方法：");
		Method[] ms = c.getMethods();
		//Class class1 = null;
		for(Method method : ms) {
			Class returnType = method.getReturnType();
			Class[] paramType = method.getParameterTypes();
			System.out.print(returnType.getSimpleName() + " " + 
					method.getName() + "(");
			if(paramType != null){
				for (int i = 0; i < paramType.length; i++) {
					if(0 == i){
						System.out.print(paramType[i].getSimpleName());
					}
					else{
						System.out.print(", " + paramType[i].getSimpleName());
					}
				}
				System.out.println(");");
			}
		}
	}
}
