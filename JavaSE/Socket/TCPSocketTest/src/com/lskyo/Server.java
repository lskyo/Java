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
 * 基於TCP協議的Socket通信
 * @author 60991
 *
 */
public class Server {
	
	
	
	public static void main(String[] args){
		int count = 0;
		
		try {
			ServerSocket serverSocket = new ServerSocket(10256);
			Socket socket = null;
			
			
			System.out.println("****服務器即將啓動，等待客戶端的連接****");
			
			
			while(true){
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				count++;
				System.out.println("客戶端的連接次數為：" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("當前客戶端的IP地址為：" + address.getHostAddress());
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
