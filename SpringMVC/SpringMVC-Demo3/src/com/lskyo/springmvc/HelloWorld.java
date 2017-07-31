package com.lskyo.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	
	@Autowired
	private UserService userService;
	
	
	
	public HelloWorld() {
		System.out.println("HelloWorld constructor...");
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("success");
		return "success";
	}
}
