package com.lskyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 10256);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);

			pw.write("用戶名：tim;密碼：123");
			pw.flush();
			
			socket.shutdownOutput();

			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String info = null;

			while ((info = br.readLine()) != null) {
				System.out.println("我是客戶端，服務器說：" + info);
			}

			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
