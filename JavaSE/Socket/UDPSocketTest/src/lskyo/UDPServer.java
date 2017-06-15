package lskyo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws IOException{
		/**
		 * 接收客戶端數據
		 */
		DatagramSocket socket = new DatagramSocket(8800);
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("**** 服務器已經啓動，等待客戶端發送數據  ****");
		socket.receive(packet);
		String info = new String(data, 0, packet.getLength());
		System.out.println("我是服務器，客戶端說：" + info);
		
		
		/**
		 * 向客戶端響應數據
		 */
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "歡迎你！".getBytes();
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		socket.send(packet2);
		socket.close();
				
		System.out.println("****   服務器已經關閉         ****");
	}
	
	
	
}
