package com.lskyo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4JTest {

	private void parseXML(){
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("src/res/bookstore.xml"));
			Element bookstore = document.getRootElement();
			Iterator it = bookstore.elementIterator();
			while(it .hasNext()){
				Element book = (Element)it.next();
				System.out.println("---------------------开始遍历某一本书--------------------");
				List<Attribute> bookAttrs = book.attributes();
				for(Attribute attr : bookAttrs){
					System.out.println(attr.getName() + ": " + attr.getValue());
				}
				Iterator itt = book.elementIterator();
				while(itt.hasNext()){
					Element bookChild = (Element) itt.next();
					System.out.println(bookChild.getName() + ": " + bookChild.getText());
				}
				System.out.println("---------------------结束遍历某一本书--------------------");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createXML(){
		Document document = DocumentHelper.createDocument();
		Element rss = document.addElement("rss");
		rss.addAttribute("version",  "2.0");
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("titel");
		title.setText("<![CDATA[lskyo正式開業！]]>");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		File file = new File("rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createXML();
	}

}
