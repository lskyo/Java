package com.lskyo.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	
	
	//init����֮�󱻵���
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("postProcessAfterInitialization:" + arg0 +", " + arg1);
		return arg0;
	}

	//init����֮ǰ������
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("postProcessBeforeInitialization:" + arg0 +", " + arg1);
		return arg0;
	}

}
