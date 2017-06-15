package com.lskyo;

public class KeyPersonThread extends Thread {
	public void run(){
		System.out.println(Thread.currentThread().getName() + "é_Ê¼ÁË‘ğôY£¡");

		
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName() + "×óÍ»ÓÒš¢£¬¹¥“ôëSÜŠ¡£¡£¡£");
		}
		
		System.out.println(Thread.currentThread().getName() + "½YÊøÁË‘ğôY£¡");
	
	
	}
}
