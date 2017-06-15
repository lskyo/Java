package com.lskyo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * ǰ����ΪԪע��
 * @author 60991
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})  //������
@Retention(RetentionPolicy.RUNTIME)             //��������
@Inherited                                      //��������̳�
@Documented										//����javadocʱ�������ע��
public @interface Description {
	/*
	 * ��Ա�������ޣ�ֻ���ǻ������ͼ�String�� Class�� Annotation�� Enumeration
	 * 
	String name(); //�޲��������쳣
	String author();
	int age() default 18;  //��ָ��Ĭ��ֵ
	*/
	//���ֻ��һ���������������Ϊvalue��
	String value();
	
}
