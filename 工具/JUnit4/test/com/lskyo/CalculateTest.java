package com.lskyo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	
	@Test
	public void testAdd(){
		assertEquals(10, new Calculate().add(5, 5));
	}
	
	@Test
	public void testSubtract(){
		assertEquals(2, new Calculate().subtract(5, 3));
	}
	
	@Test
	public void testDivide(){
		assertEquals(2, new Calculate().divide(6, 3));
	}
	
	@Test
	public void testMultiply(){
		assertEquals(18, new Calculate().multiply(6, 3));
	}

}
