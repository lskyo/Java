package com.lskyo;

public class ArmyRunnable implements Runnable {

	volatile boolean keepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepRunning){
			for(int i = 0; i < 5; i++){
				System.out.println(Thread.currentThread().getName() + "ßM¹¥Œ¦·½[" + i + "]");
				Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + "½YÊøÁËßM¹¥£¡");

	}

}
