package com.lskyo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest {
	private static ArrayList<Book> booksList = new ArrayList<Book>();

	private static void parseXML() {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		InputStreamReader isr;
		try {
			in = new FileInputStream("src/res/bookstore.xml");
			isr = new InputStreamReader(in, "UTF-8");
			Document document = saxBuilder.build(isr);
			Element rootElement = document.getRootElement();
			List<Element> bookList = rootElement.getChildren();
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("--------开始解析第" + (bookList.indexOf(book) + 1) + "本书--------");
				System.out
						.println(book.getAttributes().get(0).getName() + ": " + book.getAttributes().get(0).getValue());
				bookEntity.setId(book.getAttributes().get(0).getValue());
				List<Element> childrens = book.getChildren();
				for (Element children : childrens) {
					System.out.println(children.getName() + ": " + children.getText());
					if (children.getName().equals("name")) {
						bookEntity.setName(children.getText());
					} else if (children.getName().equals("author")) {
						bookEntity.setAuthor(children.getText());
					} else if (children.getName().equals("year")) {
						bookEntity.setYear(children.getText());
					} else if (children.getName().equals("price")) {
						bookEntity.setPrice(children.getText());
					} else if (children.getName().equals("language")) {
						bookEntity.setLanguage(children.getText());
					}
				}
				System.out.println("--------结束解析第" + (bookList.indexOf(book) + 1) + "本书--------");
				booksList.add(bookEntity);
				bookEntity = null;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Book book : booksList) {
			System.out.println(book);
		}

	}

	private static void createXML(){
		Element rss = new Element("rss");
		rss.setAttribute("version", "2.0");
		Document document = new Document(rss);
		
		Element channel = new Element("channel");
		rss.addContent(channel);
		Element title = new Element("title");
		CDATA cdata = new CDATA("lskyo正式開業！");
		title.addContent(cdata);
		channel.addContent(title);
		
		XMLOutputter outputer = new XMLOutputter(Format.getPrettyFormat());
		try {
			outputer.output(document, new FileOutputStream(new File("xmlnews.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
