package com.lskyo.springmvc.handlers;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lskyo.springmvc.entities.User;

//@SessionAttributes(value={"user"}, types={String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
	
	
	@RequestMapping("/testHelloView")
	public String testHelloView(){
		System.out.println("testHelloView");
		return "helloView";
	}
	
	
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 1. �� @ModelAttribute ��ǵķ���, ����ÿ��Ŀ�귽��ִ��֮ǰ�� SpringMVC ����! 
	 * 2. @ModelAttribute ע��Ҳ����������Ŀ�귽�� POJO ���͵����, �� value ����ֵ�����µ�����:
	 * 1). SpringMVC ��ʹ�� value ����ֵ�� implicitModel �в��Ҷ�Ӧ�Ķ���, ���������ֱ�Ӵ��뵽Ŀ�귽���������.
	 * 2). SpringMVC ��һ value Ϊ key, POJO ���͵Ķ���Ϊ value, ���뵽 request ��. 
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
			Map<String, Object> map){
		System.out.println("modelAttribute method");
		if(id != null){
			//ģ������ݿ��л�ȡ����
			User user = new User(2, "Tom", "123456", "tom@lskyo.com", 12);
			System.out.println("�����ݿ��л�ȡһ������: " + user);
			
			map.put("ttt", user);
		}
	}
	
	
	/**
	 * ��������:
	 * 1. ִ�� @ModelAttribute ע�����εķ���: �����ݿ���ȡ������, �Ѷ�����뵽�� Map ��. ��Ϊ: user
	 * 2. SpringMVC �� Map ��ȡ�� User ����, ���ѱ���������������� User ����Ķ�Ӧ����.
	 * 3. SpringMVC ������������Ŀ�귽���Ĳ���. 
	 * 
	 * ע��: �� @ModelAttribute ���εķ�����, ���뵽 Map ʱ�ļ���Ҫ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ��!
	 * 
	 * SpringMVC ȷ��Ŀ�귽�� POJO ������εĹ���
	 * 1. ȷ��һ�� key:
	 * 1). ��Ŀ�귽���� POJO ���͵Ĳ���ľ��ʹ�� @ModelAttribute ��Ϊ����, �� key Ϊ POJO ������һ����ĸ��Сд
	 * 2). ��ʹ����  @ModelAttribute ������, �� key Ϊ @ModelAttribute ע��� value ����ֵ. 
	 * 2. �� implicitModel �в��� key ��Ӧ�Ķ���, ������, ����Ϊ��δ���
	 * 1). ���� @ModelAttribute ��ǵķ������� Map �б����, �� key �� 1 ȷ���� key һ��, ����ȡ��. 
	 * 3. �� implicitModel �в����� key ��Ӧ�Ķ���, ���鵱ǰ�� Handler �Ƿ�ʹ�� @SessionAttributes ע������, 
	 * ��ʹ���˸�ע��, �� @SessionAttributes ע��� value ����ֵ�а����� key, ���� HttpSession ������ȡ key ��
	 * ��Ӧ�� value ֵ, ��������ֱ�Ӵ��뵽Ŀ�귽���������. �����������׳��쳣. 
	 * 4. �� Handler û�б�ʶ @SessionAttributes ע��� @SessionAttributes ע��� value ֵ�в����� key, ��
	 * ��ͨ������������ POJO ���͵Ĳ���, ����ΪĿ�귽���Ĳ���
	 * 5. SpringMVC ��� key �� POJO ���͵Ķ��󱣴浽 implicitModel ��, �����ᱣ�浽 request ��. 
	 * 
	 * Դ�������������
	 * 1. ���� @ModelAttribute ע�����εķ���. ʵ���ϰ� @ModelAttribute ������ Map �е����ݷ����� implicitModel ��.
	 * 2. ��������������Ŀ�����, ʵ���ϸ�Ŀ����������� WebDataBinder ����� target ����
	 * 1). ���� WebDataBinder ����:
	 * ��. ȷ�� objectName ����: ������� attrName ����ֵΪ "", �� objectName Ϊ������һ����ĸСд. 
	 * *ע��: attrName. ��Ŀ�귽���� POJO ����ʹ���� @ModelAttribute ������, �� attrName ֵ��Ϊ @ModelAttribute 
	 * �� value ����ֵ 
	 * 
	 * ��. ȷ�� target ����:
	 * 	> �� implicitModel �в��� attrName ��Ӧ������ֵ. ������, ok
	 * 	> *��������: ����֤��ǰ Handler �Ƿ�ʹ���� @SessionAttributes ��������, ��ʹ����, ���Դ� Session ��
	 * ��ȡ attrName ����Ӧ������ֵ. �� session ��û�ж�Ӧ������ֵ, ���׳����쳣. 
	 * 	> �� Handler û��ʹ�� @SessionAttributes ��������, �� @SessionAttributes ��û��ʹ�� value ֵָ���� key
	 * �� attrName ��ƥ��, ��ͨ�����䴴���� POJO ����
	 * 
	 * 2). SpringMVC �ѱ���������������� WebDataBinder �� target ��Ӧ������. 
	 * 3). *SpringMVC ��� WebDataBinder �� attrName �� target ���� implicitModel. 
	 * �������� request �������. 
	 * 4). �� WebDataBinder �� target ��Ϊ�������ݸ�Ŀ�귽�������. 
	 */
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("ttt") User user){
		System.out.println("�޸�: " + user);
		return SUCCESS;
	}
	
	
	/**
	 * @SessionAttributes ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е�������(ʵ����ʹ�õ��� value ����ֵ),
	 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ��������Ҫ�ŵ��Ự��(ʵ����ʹ�õ��� types ����ֵ)
	 * 
	 * ע��: ��ע��ֻ�ܷ����������. ���������ηŷ���. 
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map){
		User user = new User("Tom", "123456", "tom@lskyo.com", 15);
		map.put("user", user);
		map.put("school", "lskyo");
		return SUCCESS;
	}
	
	
	/**
	 * Ŀ�귽��������� Map ����(ʵ����Ҳ������ Model ���ͻ� ModelMap ����)�Ĳ���. 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		System.out.println(map.getClass().getName()); 
		map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
		return SUCCESS;
	}
	
	
	/**
	 * Ŀ�귽���ķ���ֵ������ ModelAndView ���͡� 
	 * ���п��԰�����ͼ��ģ����Ϣ
	 * SpringMVC ��� ModelAndView �� model �����ݷ��뵽 request �������. 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		modelAndView.addObject("time", new Date());
		return modelAndView; 
	}
	
	
	/**
	 * ����ʹ�� Serlvet ԭ���� API ��ΪĿ�귽���Ĳ��� ����֧����������
	 * HttpServletRequest 
	 * HttpServletResponse 
	 * HttpSession
	 * java.security.Principal 
	 * Locale InputStream 
	 * OutputStream 
	 * Reader 
	 * Writer
	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException{
		System.out.println("request:" + request);
		System.out.println("response:" + response);
		out.write("Hello SpringMVC");
	}
	
	@RequestMapping("/testPOJO")
	public String testPOJO(User user){
		System.out.println("testPOJO>>>>user:" + user);
		return SUCCESS;
	}
	
	
	
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID")String jsessionId){
		System.out.println("testCookieValue>>>>>>>jsessionId:" + jsessionId);
		return SUCCESS;
	}
	
	/**
	 * @RequestHeader ӳ������ͷ��Ϣ
	 * �÷�ͬ @RequestParam
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String al){
		System.out.println("testRequestHeader>>>>Accept-Language:" + al);
		return SUCCESS;
	}
	
	
	/**
	 * @RequestParam ��ӳ���������. 
	 * value ֵ����������Ĳ�����
	 * required �ò����Ƿ����. Ĭ��Ϊ true
	 * defaultValue ���������Ĭ��ֵ
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username")String un, @RequestParam(value="age", required=false, defaultValue="0")int age){
		System.out.println("testRequestParam>>>>>username:" + un + ">>>>>>age:" + age);
		return SUCCESS;
	}
	
	
	/**
	 * �� CRUD Ϊ������ǰ�ı�д���
	 * ������/order   POST
	 * �޸ģ�/order/update?id=1
	 * ��ȡ��/order/get?id=1
	 * ɾ����/order/delete?id=1
	 * 
	 * REST���
	 * ������/order     POST
	 * �޸ģ�/order/1   PUT
	 * ��ȡ��/order/1   GET
	 * ɾ����/order/1   DELETE
	 * 
	 * ��η��� PUT �� DELETE �����أ�
	 * 1. ��Ҫ���� HiddenHttpMethodFilter 
	 * 2. ��Ҫ���� POST ����
	 * 3. ��Ҫ�ڷ��� POST ����ʱЯ��һ�� name="_method" ��������ֵΪ DELETE �� PUT
	 * 
	 * �� SpringMVC ��Ŀ�귽������εõ� id ��? 
	 * ʹ�� @PathVariable ע��
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id){
		System.out.println("testRest PUT = " + id);
		return SUCCESS;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("testRest DELETE = " + id);
		return SUCCESS;
	}
	
	
	@RequestMapping(value="/testRest", method=RequestMethod.POST)
	public String testRest(){
		System.out.println("testRest POST");
		return SUCCESS;
	}
	
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
	public String testRest(@PathVariable Integer id){
		System.out.println("testRest GET = " + id);
		return SUCCESS;
	}
	
	
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id")Integer id){
		System.out.println("testPathVariable = " + id);
		return SUCCESS;
	}
	
	
	/**
	 * Ant �����Դ��ַ֧�� 3 ��ƥ�����
		1.	?��ƥ���ļ����е�һ���ַ�
		2.	*��ƥ���ļ����е������ַ�
		3.	**��ƥ����·��
	 */
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath(){
		System.out.println("testAntPath");
		return SUCCESS;
	}
	
	
	/**
	 * ����ͨ�� method ����ָ������ķ�����
	 * headers ����ָ������ͷ��
	 * params ����ָ���������
	 * @return
	 */
	@RequestMapping(value="/testMethod", method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	
	/**
	 * headers ����ָ������ͷ��
	 * params ����ָ���������
	 */
	@RequestMapping(value="/testParamsAndHeaders", params={"username", "age!=18"}, headers={"Accept-Language=zh-CN,zh;q=0.8"})
	public String testParamsAndHeaders(){
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	
	
	/**
	 * 1. @RequestMapping �������η�����������������
	 * 2. 
	 * 1). �ඨ�崦���ṩ����������ӳ����Ϣ������� WEB Ӧ�õĸ�Ŀ¼
	 * 2). ���������ṩ��һ����ϸ��ӳ����Ϣ��������ඨ�崦�� URL��
	 * ���ඨ�崦δ��ע @RequestMapping���򷽷�����ǵ� URL �����WEB Ӧ�õĸ�Ŀ¼
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
}
