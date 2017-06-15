package com.lskyo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ErrorAndFailTest {

	@Test
	public void testAdd(){
		assertEquals(9, new Calculate().add(5, 5));
	}
	
	@Test
	public void testDivide(){
		assertEquals(2, new Calculate().divide(6, 0));
	}
}
