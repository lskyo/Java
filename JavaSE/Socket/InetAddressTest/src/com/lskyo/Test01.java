package com.lskyo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author 60991
 *
 */
public class Test01 {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("Ӌ��C����" + address.getHostName());
		System.out.println("IP��ַ��" + address.getHostAddress());
		
		byte[] bytes = address.getAddress();
		System.out.println("IP��ַ�ֹ���" + Arrays.toString(bytes));
		
		System.out.println(address);
		
//		InetAddress address2 = InetAddress.getByName("lam3allen-pc");
		InetAddress address2 = InetAddress.getByName("lam3allen-pc");
		System.out.println("Ӌ��C����" + address2.getHostName());
		System.out.println("IP��ַ��" + address2.getHostAddress());
	}

}
