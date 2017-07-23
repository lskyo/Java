package com.lskyo.spring.tx;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	
	@Test
	public void testCashier(){
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	
	@Test
	public void testBookShopDaoUpdateAccount(){
		bookShopDao.updateUserAccount("AA", 180);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock(){
		bookShopDao.updateBookStock("1001");
	}
	
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

}
