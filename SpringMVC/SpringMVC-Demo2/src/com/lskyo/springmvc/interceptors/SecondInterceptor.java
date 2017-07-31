package com.lskyo.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecondInterceptor implements HandlerInterceptor {

	
	
	/**
	 * ��Ⱦ��ͼ֮�󱻵���
	 * 
	 * �ͷ���Դ�á�
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("SecondInterceptor afterCompletion..");
	}

	
	
	
	/**
	 * ����Ŀ�귽��֮����Ⱦ��ͼ֮ǰ������
	 * 
	 * ���Զ��������е����Ի���ͼ�����޸ġ�
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("SecondInterceptor postHandle..");
	}

	
	
	
	
	/**
	 * ��Ŀ�귽��֮ǰ����
	 * ������ֵΪfalse���򲻻���ú�������������Ŀ�귽��
	 * 
	 * ���Կ�����Ȩ�ޣ���־������ȡ�
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("SecondInterceptor preHandle..");
		return true;
	}

}
