package com.lskyo;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	public static void Test02(String[] args) {
		try {
			URL baidu = new URL("http://www.baidu.com");
			URL url = new URL(baidu, "/index.html?username=tom#test");
			
			
			System.out.println("�f�h��" + url.getProtocol());
			System.out.println("���C��" + url.getHost());
			System.out.println("�˿ڣ�" + url.getPort());
			System.out.println("�ļ�·����" + url.getPath());
			System.out.println("�ļ�����" + url.getFile());
			System.out.println("����·����" + url.getRef());
			System.out.println("��ԃ�ַ�����" + url.getQuery());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
