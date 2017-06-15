package com.lskyo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AnnotationTest {

	@Test(expected=ArithmeticException.class)
	public void testDivide(){
		assertEquals(2, new Calculate().divide(6, 0));
	}
	
	@Test(timeout=2020)
	public void testTimeout(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test(timeout=2020)
	public void testWhile(){
		while(true){
			System.out.println("running...");
		}
	}

}
