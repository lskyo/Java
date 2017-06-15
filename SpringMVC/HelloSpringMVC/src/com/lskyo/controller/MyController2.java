package com.lskyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;


/**
 * 
 * @author lskyo
 * 按照HttpRequestHandlerAdapter的规则，实现HttpRequestHandler接口的Handler
 *
 */
public class MyController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setAttribute("message", "按照HttpRequestHandlerAdapter的规则，实现HttpRequestHandler接口的Handler");
		arg0.getRequestDispatcher("/WEB-INF/message.jsp").forward(arg0, arg1);
	}

}
