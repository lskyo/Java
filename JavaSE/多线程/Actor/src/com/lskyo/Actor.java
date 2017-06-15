package com.lskyo;

public class Actor extends Thread {
	
	public void run(){
		System.out.println(getName() + "是一個演員！");
		boolean keepRunning = true;
		int count = 0;
		while(keepRunning){
			
			System.out.println(getName() + "登臺演出：" + (++count));
			
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

		System.out.println(getName() + "的演出結束了！");
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
		System.out.println(Thread.currentThread().getName() + "是一個演員！");
		boolean keepRunning = true;
		int count = 0;
		while(keepRunning){
			
			System.out.println(Thread.currentThread().getName() + "登臺演出：" + (++count));
			
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

		System.out.println(Thread.currentThread().getName() + "的演出結束了！");
	}
	
}
