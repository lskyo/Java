package com.lskyo;

public class ArmyRunnable implements Runnable {

	volatile boolean keepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepRunning){
			for(int i = 0; i < 5; i++){
				System.out.println(Thread.currentThread().getName() + "�M������[" + i + "]");
				Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + "�Y�����M����");

	}

}
