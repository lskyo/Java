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
		System.out.println("計算機名：" + address.getHostName());
		System.out.println("IP地址：" + address.getHostAddress());
		
		byte[] bytes = address.getAddress();
		System.out.println("IP地址字節：" + Arrays.toString(bytes));
		
		System.out.println(address);
		
//		InetAddress address2 = InetAddress.getByName("lam3allen-pc");
		InetAddress address2 = InetAddress.getByName("lam3allen-pc");
		System.out.println("計算機名：" + address2.getHostName());
		System.out.println("IP地址：" + address2.getHostAddress());
	}

}
