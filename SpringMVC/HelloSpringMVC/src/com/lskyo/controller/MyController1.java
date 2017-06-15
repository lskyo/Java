package com.lskyo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



/**
 * 
 * @author lskyo
 * 按照HttpRequestHandlerAdapter的规则，实现Controller接口的Handler
 *
 */
public class MyController1 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("message", "按照HttpRequestHandlerAdapter的规则，实现Controller接口的Handler");
		modelandview.setViewName("message");
		return modelandview;
	}

}
