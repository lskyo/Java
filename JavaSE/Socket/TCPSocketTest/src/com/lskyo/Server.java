package com.lskyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���TCP�f�h��Socketͨ��
 * @author 60991
 *
 */
public class Server {
	
	
	
	public static void main(String[] args){
		int count = 0;
		
		try {
			ServerSocket serverSocket = new ServerSocket(10256);
			Socket socket = null;
			
			
			System.out.println("****�������������ӣ��ȴ��͑��˵��B��****");
			
			
			while(true){
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				count++;
				System.out.println("�͑��˵��B�ӴΔ��飺" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�͑��˵�IP��ַ�飺" + address.getHostAddress());
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
