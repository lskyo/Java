package com.lskyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author lskyo
 * 按照RequestMappingHandlerAdapter的规则，使用注解开发的Handler
 */
@Controller
public class MyController3 {
	
	@RequestMapping("/message4.action")
	public ModelAndView setMessage() throws Exception{
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("message", "按照RequestMappingHandlerAdapter的规则，使用注解开发的Handler");
		modelandview.setViewName("message");
		return modelandview;
	}
}
