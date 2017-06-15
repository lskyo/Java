package com.lskyo;

public class Stage extends Thread {

	public void run(){
		
		System.out.println("歡迎觀看隋唐演義！");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("大幕徐徐拉開。。。");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("話説隋朝末年，隨軍與農民軍殺得昏天黑地。。。");
		
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋軍");
		Thread armyOfSuiRevolt = new Thread(armyTaskOfSuiDynasty,"農民起義軍");
		
		armyOfSuiDynasty.start();
		armyOfSuiRevolt.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("正當雙方激戰正酣，半路殺出了個程咬金。");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		
		System.out.println("程咬金的理想就是結束戰爭，使百姓安居樂業 !");
		
		armyTaskOfRevolt.keepRunning = false;
		armyTaskOfSuiDynasty.keepRunning = false;
		
//		armyOfSuiDynasty.stop();
//		armyOfSuiRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mrCheng.start();
		
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("戰爭結束，人民安居樂業，程先生實現了積極的人生理想！");
		System.out.println("謝謝觀看隋唐演義，再見！");
		
//		armyTaskOfRevolt.keepRunning = false;
//		armyTaskOfSuiDynasty.keepRunning = false;
//		
//		
//		try {
//			armyOfSuiRevolt.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stage().start();
	}

}
