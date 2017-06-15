package com.lskyo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 前四行为元注解
 * @author 60991
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})  //作用域
@Retention(RetentionPolicy.RUNTIME)             //生命周期
@Inherited                                      //允许子类继承
@Documented										//生成javadoc时会包含此注解
public @interface Description {
	/*
	 * 成员类型受限，只能是基本类型及String， Class， Annotation， Enumeration
	 * 
	String name(); //无参数，无异常
	String author();
	int age() default 18;  //可指定默认值
	*/
	//如果只有一个参数，则参数名为value；
	String value();
	
}
