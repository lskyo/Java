package com.lskyo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RegisterInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("------------------RegisterInterceptor start...------------------");
		String resultString = arg0.invoke();
		System.out.println("------------------RegisterInterceptor stop...------------------");
		return resultString;
	}

}
