package com.lskyo.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {


	/**
	 * 1. ʹ�� @RequestMapping ��ӳ�������URL
	 * 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ������ InternalResourceViewResolver ��ͼ���������������½�����
	 * ͨ�� prefix + returnVal + ��׺ �����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ�����ת������
	 */
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("Hello World!");
		return "success";
	}
}
