package lskyo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClinet {

	public static void main(String[] args) throws IOException{
		/**
		 * 向服務器發送數據
		 */
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用戶名：admin；密碼：123".getBytes();
		DatagramPacket packet = new DatagramPacket(data,data.length, address, port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		
		/**
		 * 接收服務器端響應數據
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		socket.receive(packet2);
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("我是客戶端，服務器說：" + reply);
		
		socket.close();
	}
}
