package com.lskyo;

public class Actor extends Thread {
	
	public void run(){
		System.out.println(getName() + "��һ���݆T��");
		boolean keepRunning = true;
		int count = 0;
		while(keepRunning){
			
			System.out.println(getName() + "���_�ݳ���" + (++count));
			
			if(count == 100){
				keepRunning = false;
			}
			
			if(count % 10 == 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println(getName() + "���ݳ��Y���ˣ�");
	}
	
	public static void main(String[] args){
		
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		Thread actressThread = new Thread(new Actress(), "Ms.Runnable");
		actressThread.start();
	}

}


class Actress implements Runnable{

	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName() + "��һ���݆T��");
		boolean keepRunning = true;
		int count = 0;
		while(keepRunning){
			
			System.out.println(Thread.currentThread().getName() + "���_�ݳ���" + (++count));
			
			if(count == 100){
				keepRunning = false;
			}
			
			if(count % 10 == 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println(Thread.currentThread().getName() + "���ݳ��Y���ˣ�");
	}
	
}
