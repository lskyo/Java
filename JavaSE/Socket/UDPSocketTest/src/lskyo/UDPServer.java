package lskyo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws IOException{
		/**
		 * ���տ͑��˔���
		 */
		DatagramSocket socket = new DatagramSocket(8800);
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("**** �������ѽ����ӣ��ȴ��͑��˰l�͔���  ****");
		socket.receive(packet);
		String info = new String(data, 0, packet.getLength());
		System.out.println("���Ƿ��������͑����f��" + info);
		
		
		/**
		 * ��͑���푑�����
		 */
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "�gӭ�㣡".getBytes();
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		socket.send(packet2);
		socket.close();
				
		System.out.println("****   �������ѽ��P�]         ****");
	}
	
	
	
}
