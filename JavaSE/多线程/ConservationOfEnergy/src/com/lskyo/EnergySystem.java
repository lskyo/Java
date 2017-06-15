package com.lskyo;

public class EnergySystem {

	private final double[] energyBoxes;
	private final Object lockObj = new Object();

	public EnergySystem(int n, double initialEnergy) {
		energyBoxes = new double[n];
		for (int i = 0; i < energyBoxes.length; i++) {
			energyBoxes[i] = initialEnergy;
		}
	}

	public void transfer(int from, int to, double amount) {
		synchronized (lockObj) {
//			if (energyBoxes[from] < amount)
//				return;
			while(energyBoxes[from] < amount){
				try {
					lockObj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			energyBoxes[from] -= amount;
			System.out.printf("從%d轉移%10.2f單位能量到%d", from, amount, to);
			energyBoxes[to] += amount;
			System.out.printf("能量總和：%10.2f%n", getTotalEnergies());
			
			lockObj.notifyAll();
			
		}

	}

	public double getTotalEnergies() {
		double sum = 0;
		for (double amount : energyBoxes)
			sum += amount;
		return sum;
	}

	public int getBoxAmount() {
		return energyBoxes.length;
	}
}
