package com.lskyo;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	public static void Test02(String[] args) {
		try {
			URL baidu = new URL("http://www.baidu.com");
			URL url = new URL(baidu, "/index.html?username=tom#test");
			
			
			System.out.println("協議：" + url.getProtocol());
			System.out.println("主機：" + url.getHost());
			System.out.println("端口：" + url.getPort());
			System.out.println("文件路徑：" + url.getPath());
			System.out.println("文件名：" + url.getFile());
			System.out.println("相對路徑：" + url.getRef());
			System.out.println("查詢字符串：" + url.getQuery());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
