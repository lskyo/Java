package com.lskyo.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SpringMVCTestExceptionHandler {

	
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handlerRuntimeException(Exception ex){
//		System.out.println("---> ���� RuntimeException �쳣�ˣ�" + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	
	
	/**
	 * 1. �� @ExceptionHandler ����������п��Լ��� Exception ���͵Ĳ������ò�������Ӧ�������쳣����
	 * 2. @ExceptionHandler ����������в��ܴ���Map�� ��ϣ�����쳣���뵽ҳ���У���ʹ�� ModelAndView ��Ϊ����ֵ��
	 * 3. �� @ExceptionHandler ������ǵ��쳣�����ȼ�������
	 * 4. ����ڵ�ǰ Handler ���Ҳ��� @ExceptionHandler ������������ֵ��쳣��
	 *    ���ȥ  @ControllerAdvice ��ǵ����в��� @ExceptionHandler ��ǵķ����������쳣��
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerArithmeticException(Exception ex){
		System.out.println("---> ���� ArithmeticException �쳣�ˣ�" + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
