package com.lskyo.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SpringMVCTestExceptionHandler {

	
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handlerRuntimeException(Exception ex){
//		System.out.println("---> 出现 RuntimeException 异常了！" + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	
	
	/**
	 * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数，该参数即对应发生的异常对象
	 * 2. @ExceptionHandler 方法的入参中不能传入Map。 若希望把异常传入到页面中，需使用 ModelAndView 作为返回值。
	 * 3. 在 @ExceptionHandler 方法标记的异常有优先级的问题
	 * 4. 如果在当前 Handler 中找不到 @ExceptionHandler 方法来处理出现的异常，
	 *    则会去  @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常。
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerArithmeticException(Exception ex){
		System.out.println("---> 出现 ArithmeticException 异常了！" + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
