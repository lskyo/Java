package com.lskyo;

public class Stage extends Thread {

	public void run(){
		
		System.out.println("�gӭ�^���������x��");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("��Ļ�������_������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Ԓ�h�峯ĩ�꣬�S܊�c�r��܊���û���ڵء�����");
		
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"��܊");
		Thread armyOfSuiRevolt = new Thread(armyTaskOfSuiDynasty,"�r�����x܊");
		
		armyOfSuiDynasty.start();
		armyOfSuiRevolt.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�����p��������������·�����˂���ҧ��");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		
		System.out.println("��ҧ���������ǽY���𠎣�ʹ���հ��Ә��I !");
		
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
		
		
		System.out.println("�𠎽Y�������񰲾Ә��I�����������F�˷e�O���������룡");
		System.out.println("�x�x�^���������x����Ҋ��");
		
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
