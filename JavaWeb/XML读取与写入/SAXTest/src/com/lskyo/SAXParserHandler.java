package com.lskyo;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

	Book book = null;
	String value = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	int bookIndex = 0;
	
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.startDocument();
		System.out.println("SAX解析开始。");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.endDocument();
		System.out.println("SAX解析结束。");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		if(qName.equals("book")){
			book = new Book();
			bookIndex++;
			System.out.println("-------------------开始遍历第"+ bookIndex + "本书----------------------");
//			for(int i = 0; i < attributes.getLength(); i++){
//				
//			}
			System.out.println("id: " + attributes.getValue("id"));
			if(attributes.getQName(0).equals("id")){
				book.setId(attributes.getValue("id"));
			}
		}
		else if(!qName.equals("book") && !qName.equals("bookstore")){
			System.out.print(qName + ": ");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//super.endElement(uri, localName, qName);
		if(qName.equals("book")){
			bookList.add(book);
			book = null;
			System.out.println("-------------------结束遍历第"+ bookIndex + "本书----------------------");
		}else if(qName.equals("name")){
			book.setName(value);
		}else if(qName.equals("author")){
			book.setAuthor(value);
		}else if(qName.equals("year")){
			book.setYear(value);
		}else if(qName.equals("price")){
			book.setPrice(value);
		}else if(qName.equals("language")){
			book.setLanguage(value);
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		value = new String(ch,start,length);
		if(!value.trim().equals("")){
			System.out.println(value);
		}
	}
	
}
