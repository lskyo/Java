package com.lskyo;

public class KeyPersonThread extends Thread {
	public void run(){
		System.out.println(Thread.currentThread().getName() + "�_ʼ�ˑ��Y��");

		
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName() + "��ͻ�Қ��������S܊������");
		}
		
		System.out.println(Thread.currentThread().getName() + "�Y���ˑ��Y��");
	
	
	}
}
